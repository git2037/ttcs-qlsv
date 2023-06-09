package com.qlsv.controller.web;

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

@WebServlet(urlPatterns = "/thong-tin-ca-nhan")
public class PersonalInforController extends HttpServlet {
    @Inject
    private IStudentService studentService;
    @Inject
    private IClassService classService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int studentID = (int) req.getSession().getAttribute("studentID");
            StudentModel studentModel = studentService.getOneByID(studentID);
            ClassModel classModel = classService.getOneByID(studentModel.getClassID());
            req.setAttribute("classModel", classModel);
            req.setAttribute("studentModel", studentModel);
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/personalInfor.jsp");
            rd.forward(req, resp);
        }catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
