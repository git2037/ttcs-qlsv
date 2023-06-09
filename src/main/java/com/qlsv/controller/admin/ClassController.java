package com.qlsv.controller.admin;

import com.qlsv.model.ClassModel;
import com.qlsv.model.CourseModel;
import com.qlsv.services.IClassService;
import com.qlsv.services.ICourseService;
import com.qlsv.services.IStudentService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-class"})
public class ClassController extends HttpServlet {
    @Inject
    private IClassService classService;
    @Inject
    private ICourseService courseService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<CourseModel> courseList = courseService.getAll();
            req.setAttribute("courseList", courseList); //
            String action = req.getParameter("action");
            String view = "";
            List<ClassModel> classList = classService.getAll();

            if (action == null) { // trang chu
                String idString = req.getParameter("id");
                if (idString != null) {
                    int id = Integer.parseInt(idString);
                    classList.removeIf(classModel -> classModel.getCourseID() != id);
                }

                req.setAttribute("classList", classList); //
                view = "/views/admin/class/list.jsp";
            } else {
                if (action.equals("update")) {
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("classModel", classService.getOneByID(id)); //
                    view = "/views/admin/class/edit.jsp";
                } else if (action.equals("insert")){
                    view = "/views/admin/class/edit.jsp";
                }
            }

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
