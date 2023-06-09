package com.qlsv.controller.admin;

import com.qlsv.model.SubjectModel;
import com.qlsv.services.ISubjectService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-subject"})
public class SubjectController extends HttpServlet {
    @Inject
    private ISubjectService subjectService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String action = req.getParameter("action");
            String view = "";
            if (action == null) {
                req.setAttribute("subjectList", subjectService.getAll()); //
                view = "/views/admin/subject/list.jsp";
            } else if (action.equals("insert")){
                view = "/views/admin/subject/edit.jsp";
            } else if (action.equals("update")){
                int id = Integer.parseInt(req.getParameter("id"));
                SubjectModel subjectModel = subjectService.getOneByID(id);
                req.setAttribute("subjectModel", subjectModel); //
                view = "/views/admin/subject/edit.jsp";
            }

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
