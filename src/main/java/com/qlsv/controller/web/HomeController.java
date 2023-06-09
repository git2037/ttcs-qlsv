package com.qlsv.controller.web;

import com.qlsv.model.AccountModel;
import com.qlsv.model.AdminModel;
import com.qlsv.model.RoleModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.*;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/dang-xuat"})
public class HomeController extends HttpServlet {
    @Inject
    private IAccountService accountService;
    @Inject
    private IRoleService roleService;
    @Inject
    private IAdminService adminService;
    @Inject
    private IStudentService studentService;
    @Inject
    private INotificationService notificationService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

            String action = req.getParameter("action");
            if (action == null) {
                RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
                rd.forward(req, resp);

            } else if (action.equals("login")){
                RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(req, resp);
            } else if (action.equals("logout")) {
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath());
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");
            AccountModel acc = accountService.getOneByUserNameAndPassword(userName, password);

            if (acc == null) { // khong ton tai tai khoan
                ResourceBundle rb = ResourceBundle.getBundle("notification");
                req.setAttribute("error", rb.getString("usernameOrPasswordInvalid"));
                RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(req, resp);
            } else { // ton tai tai khoan
                int accID = acc.getRoleID();
                RoleModel roleModel = roleService.getOneByID(accID);

                if (roleModel.getCode().equals("admin")) { // tai khoan admin
                    AdminModel adminModel = adminService.getOneByAccountID(acc.getId());
                    req.getSession().setAttribute("fullName", adminModel.getFullname());
                    req.getSession().setAttribute("role", roleModel.getCode());
                    req.getServletContext().setAttribute("numberOfNewNotification",
                            notificationService.getAllByStatus(0).size());
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                } else  if (roleModel.getCode().equals("student")){ // tai khoan sinh vien
                    StudentModel studentModel = studentService.getOneByAccountID(acc.getId());
                    req.getSession().setAttribute("fullName", studentModel.getFullname());
                    req.getSession().setAttribute("studentID", studentModel.getId());
                    req.getSession().setAttribute("role", roleModel.getCode());
                    resp.sendRedirect(req.getContextPath() + "/trang-chu");
                }
            }
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
