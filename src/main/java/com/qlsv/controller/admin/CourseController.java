package com.qlsv.controller.admin;

import com.qlsv.services.ICourseService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-course"})
public class CourseController extends HttpServlet {
    @Inject
    private ICourseService courseService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String action = req.getParameter("action");
            String view = "";
            if (action == null) {
                req.setAttribute("courseList", courseService.getAll());
                view = "/views/admin/course/list.jsp";
            } else if (action.equals("insert")){
                view = "/views/admin/course/edit.jsp";
            }

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
