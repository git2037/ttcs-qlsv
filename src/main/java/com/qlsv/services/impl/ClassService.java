package com.qlsv.services.impl;

import com.qlsv.dao.IClassDAO;
import com.qlsv.dao.ICourseDAO;
import com.qlsv.model.AbstractModel;
import com.qlsv.model.ClassModel;
import com.qlsv.model.CourseModel;
import com.qlsv.services.IClassService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassService implements IClassService {
    @Inject
    private IClassDAO classDAO;
    @Inject
    private ICourseDAO courseDAO;

    @Override
    public ClassModel getOneByID(int id) {
        return classDAO.getOneByID(id);
    }

    @Override
    public ClassModel getOneByCode(String code) {
        return classDAO.getOneByCode(code);
    }

    @Override
    public List<ClassModel> getAll() {
        return classDAO.getAll();
    }

    @Override
    public Integer insert(ClassModel classModel) {
        List<CourseModel> courseModelList = courseDAO.getAll();
        CourseModel courseModel = findCourseModelByCourseCodeInCourseList(classModel.getCourseCode(), courseModelList);
        classModel.setCourseID(courseModel.getId());

        setClassCodeAndClassName(classModel, classModel.getName(), courseModel.getCode());
        return classDAO.insert(classModel);
    }

    @Override
    public void update(ClassModel classModel) {
        classDAO.update(classModel);
    }

    @Override
    public void delete(int id) {
        classDAO.delete(id);
    }

    public CourseModel findCourseModelByCourseCodeInCourseList(String courseCode, List<CourseModel> courseModelList) {
        for (CourseModel courseModel : courseModelList) {
            if (courseModel.getCode().equals(courseCode)) {
                return courseModel;
            }
        }
        return null;
    }

    public void setClassCodeAndClassName(ClassModel classModel, String className, String courseCode){
        className = className.toUpperCase();
        Map<String, String> classNameMap = new HashMap<>();
        classNameMap.put("A", "01");
        classNameMap.put("B", "02");
        classNameMap.put("C", "03");
        classNameMap.put("D", "04");
        classNameMap.put("E", "05");
        classNameMap.put("F", "06");
        classNameMap.put("G", "07");
        classNameMap.put("H", "08");
        classNameMap.put("I", "09");
        classNameMap.put("J", "10");

        if (classNameMap.containsKey(className)) {
            String val = classNameMap.get(className);

            String classCode = courseCode.concat(val);
            String name = courseCode.concat(className);
            classModel.setCode(classCode);
            classModel.setName(name);
        }
    }
}
