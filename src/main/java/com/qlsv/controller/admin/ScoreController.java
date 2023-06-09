package com.qlsv.controller.admin;

import com.qlsv.model.ScoreModel;
import com.qlsv.model.StudentModel;
import com.qlsv.model.SubjectModel;
import com.qlsv.services.IScoreService;
import com.qlsv.services.IStudentService;
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

@WebServlet(urlPatterns = {"/admin-score"})
public class ScoreController extends HttpServlet {
    @Inject
    private IStudentService studentService;
    @Inject
    private ISubjectService subjectService;
    @Inject
    private IScoreService scoreService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String action = req.getParameter("action");
            String view = "";
            List<StudentModel> studentList = studentService.getAll();
            List<SubjectModel> subjectList = subjectService.getAll();
            List<ScoreModel> scoreList = scoreService.getAll();

            if (action == null) { // trang danh sach
                String studentID = req.getParameter("studentID");
                String subjectID = req.getParameter("subjectID");

                if (studentID != null) {
                    int id = Integer.parseInt(studentID);
                    studentList.removeIf(studentModel -> studentModel.getId() != id);
                    scoreList.removeIf(scoreModel -> scoreModel.getStudentID() != id);
                } else if (subjectID != null){
                    int id = Integer.parseInt(subjectID);
                    subjectList.removeIf(subjectModel -> subjectModel.getId() != id);
                    scoreList.removeIf(scoreModel -> scoreModel.getSubjectID() != id);
                }

                req.setAttribute("scoreList", scoreList); //
                view = "/views/admin/score/list.jsp";
            } else { // trang insert or update
                if (action.equals("insert")) { // trang insert
                    view = "/views/admin/score/edit.jsp";
                } else if(action.equals("update")){ // trang update
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("scoreModel", scoreService.getOneByID(id)); //
                    view = "/views/admin/score/edit.jsp";
                }
            }
            req.setAttribute("studentList", studentList); //
            req.setAttribute("subjectList", subjectList); //

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
