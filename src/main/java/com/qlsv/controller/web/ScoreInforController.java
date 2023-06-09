package com.qlsv.controller.web;

import com.qlsv.model.ScoreModel;
import com.qlsv.services.IScoreService;
import com.qlsv.services.ISubjectService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/ds-diem"})
public class ScoreInforController extends HttpServlet {
    @Inject
    private IScoreService scoreService;
    @Inject
    private ISubjectService subjectService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int studentID = (int) req.getSession().getAttribute("studentID");
            List<ScoreModel> scoreModelList = scoreService.getAllByStudentID(studentID);
            req.setAttribute("scoreList", scoreModelList);
            req.setAttribute("gpa", scoreService.calculateGPA(studentID));
            req.setAttribute("subjectList", subjectService.getAll());
            RequestDispatcher rd = req.getRequestDispatcher("views/web/score.jsp");
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
