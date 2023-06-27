package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.StudentModel;
import com.qlsv.services.IClassService;
import com.qlsv.services.IStudentService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-student"})
public class StudentAPI extends HttpServlet {
    @Inject
    private IStudentService studentService;
    @Inject
    private IClassService classService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            StudentModel studentModel = ApiUtil.getInstance().toModel(req, StudentModel.class);

            studentService.insert(studentModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), studentModel);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            ObjectMapper om = new ObjectMapper();
            StudentModel studentModel = ApiUtil.getInstance().toModel(req, StudentModel.class);
            studentService.update(studentModel);
            om.writeValue(resp.getOutputStream(), studentModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
