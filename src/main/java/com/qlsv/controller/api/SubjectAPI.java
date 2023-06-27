package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.SubjectModel;
import com.qlsv.services.ISubjectService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-subject"})
public class SubjectAPI extends HttpServlet {
    @Inject
    private ISubjectService subjectService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            SubjectModel subjectModel = ApiUtil.getInstance().toModel(req, SubjectModel.class);
            subjectService.insert(subjectModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), subjectModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            SubjectModel subjectModel = ApiUtil.getInstance().toModel(req, SubjectModel.class);
            subjectService.update(subjectModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), subjectModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
