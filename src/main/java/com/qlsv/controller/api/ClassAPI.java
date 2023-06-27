package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.ClassModel;
import com.qlsv.model.CourseModel;
import com.qlsv.services.IClassService;
import com.qlsv.services.ICourseService;
import com.qlsv.utils.ApiUtil;
import com.qlsv.utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/api-class")
public class ClassAPI extends HttpServlet {
    @Inject
    private IClassService classService;
    @Inject
    private ICourseService courseService;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<CourseModel> courseList = courseService.getAll();
            resp.setContentType("application/json");

            ClassModel classModel = ApiUtil.getInstance().toModel(req, ClassModel.class);
            CourseModel courseModel = CommonUtils.getInstance().
                    findCourseModelByCourseCodeInCourseList(classModel.getCourseCode(), courseList);
            CommonUtils.getInstance().setClassCodeAndClassName(classModel, classModel.getName(),
                    courseModel.getCode());

            classModel.setCourseID(courseModel.getId());
            classService.insert(classModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), classModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<CourseModel> courseList = courseService.getAll();
            resp.setContentType("application/json");

            ClassModel classModel = ApiUtil.getInstance().toModel(req, ClassModel.class);
            CourseModel courseModel = CommonUtils.getInstance().
                    findCourseModelByCourseCodeInCourseList(classModel.getCourseCode(), courseList);
            CommonUtils.getInstance().setClassCodeAndClassName(classModel, classModel.getName(),
                    courseModel.getCode());

            classModel.setCourseID(courseModel.getId());
            classService.update(classModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), classModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
