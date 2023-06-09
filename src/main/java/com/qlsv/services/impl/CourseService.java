package com.qlsv.services.impl;

import com.qlsv.dao.ICourseDAO;
import com.qlsv.model.CourseModel;
import com.qlsv.services.ICourseService;

import javax.inject.Inject;
import java.util.List;

public class CourseService implements ICourseService {
    @Inject
    private ICourseDAO courseDAO;
    @Override
    public CourseModel getOneByCode(String code) {
        return courseDAO.getOneByCode(code);
    }

    @Override
    public List<CourseModel> getAll() {
        return courseDAO.getAll();
    }

    @Override
    public Integer insert(CourseModel courseModel) {
        return courseDAO.insert(courseModel);
    }

    @Override
    public void update(CourseModel courseModel) {
        courseDAO.update(courseModel);
    }

    @Override
    public void delete(int id) {
        courseDAO.delete(id);
    }
}
