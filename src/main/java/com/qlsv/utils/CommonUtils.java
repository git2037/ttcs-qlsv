package com.qlsv.utils;

import com.qlsv.model.ClassModel;
import com.qlsv.model.CourseModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
    public static CommonUtils getInstance() {
        return new CommonUtils();
    }

    public ClassModel findClassModelByClassNameInClassList(String className, List<ClassModel> classList) {
        for (ClassModel classModel : classList) {
            if (classModel.getName().equals(className)) {
                return classModel;
            }
        }
        return null;
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
