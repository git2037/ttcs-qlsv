package com.qlsv.controller.web;

import com.qlsv.model.AccountModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.IAccountService;
import com.qlsv.services.IStudentService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/thay-mat-khau")
public class ChangePasswordController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Inject
    private IStudentService studentService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int studentID = (int) req.getSession().getAttribute("studentID");
            StudentModel studentModel = studentService.getOneByID(studentID);
            AccountModel acc = accountService.getOneByID(studentModel.getAccountID());
            req.setAttribute("acc", acc);
            RequestDispatcher rd = req.getRequestDispatcher("/views/web/changePassword.jsp");
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
