package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.ClassModel;
import com.qlsv.services.IClassService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api-class")
public class ClassAPI extends HttpServlet {
    @Inject
    private IClassService classService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");

            ClassModel classModel = ApiUtil.getInstance().toModel(req, ClassModel.class);
            classService.insert(classModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), classModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
