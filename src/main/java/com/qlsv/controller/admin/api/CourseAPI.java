package com.qlsv.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.CourseModel;
import com.qlsv.services.ICourseService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-course"})
public class CourseAPI extends HttpServlet {
    @Inject
    private ICourseService courseService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            CourseModel courseModel = ApiUtil.getInstance().toModel(req, CourseModel.class);
            courseService.insert(courseModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), courseModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            CourseModel courseModel = ApiUtil.getInstance().toModel(req, CourseModel.class);
            courseService.update(courseModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), courseModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
