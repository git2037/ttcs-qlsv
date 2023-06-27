package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.ScoreModel;
import com.qlsv.model.StudentModel;
import com.qlsv.model.SubjectModel;
import com.qlsv.services.IScoreService;
import com.qlsv.services.IStudentService;
import com.qlsv.services.ISubjectService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api-score")
public class ScoreAPI extends HttpServlet {
    @Inject
    private IScoreService scoreService;
    @Inject
    private IStudentService studentService;
    @Inject
    private ISubjectService subjectService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");

            ScoreModel scoreModel = ApiUtil.getInstance().toModel(req, ScoreModel.class);
            StudentModel studentModel = studentService.getOneByCode(scoreModel.getStudentCode());
            SubjectModel subjectModel = subjectService.getOneByCode(scoreModel.getSubjectCode());

            scoreModel.setSubjectID(subjectModel.getId());
            scoreModel.setStudentID(studentModel.getId());
            scoreService.insert(scoreModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), scoreModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");

            ScoreModel scoreModel = ApiUtil.getInstance().toModel(req, ScoreModel.class);
            StudentModel studentModel = studentService.getOneByCode(scoreModel.getStudentCode());
            SubjectModel subjectModel = subjectService.getOneByCode(scoreModel.getSubjectCode());

            scoreModel.setSubjectID(subjectModel.getId());
            scoreModel.setStudentID(studentModel.getId());
            scoreService.update(scoreModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), scoreModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");

            ScoreModel scoreModel = ApiUtil.getInstance().toModel(req, ScoreModel.class);
            scoreService.delete(scoreModel.getId());
            new ObjectMapper().writeValue(resp.getOutputStream(), scoreModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
