package com.qlsv.controller.admin;

import com.qlsv.model.ClassModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.IClassService;
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

@WebServlet(urlPatterns = {"/admin-student"})
public class StudentController extends HttpServlet {
    @Inject
    private IStudentService studentService;
    @Inject
    private IClassService classService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String action = req.getParameter("action");
            String view = "";


            if (action == null) { // trang danh sach
                String type = req.getParameter("type");
                List<StudentModel> studentList = studentService.getAll();
                String classCode = req.getParameter("classCode");

                if (type == null && classCode != null) {
                    ClassModel classModel = classService.getOneByCode(classCode);
                    studentList.removeIf(studentModel -> studentModel.getClassID() != classModel.getId());
                } else if (type != null){
                    if (type.equals("current")){ // danh sach sv hien tai
                        studentList.removeIf(studentModel -> studentModel.getStatus() == 0);
                    } else if (type.equals("graduated")) { // ds sv da tot nghiep
                        studentList.removeIf(studentModel -> studentModel.getStatus() == 1);
                    }
                }

                req.setAttribute("studentList", studentList); //
                view = "/views/admin/student/list.jsp";
            } else { // trang insert or update
                if (action.equals("insert")) { // trang insert
                    view = "/views/admin/student/edit.jsp";
                } else if(action.equals("update")){ // trang update
                    int id = Integer.parseInt(req.getParameter("id"));
                    req.setAttribute("studentModel", studentService.getOneByID(id)); //
                    view = "/views/admin/student/edit.jsp";
                }
            }
            req.setAttribute("classList", classService.getAll()); //

            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
