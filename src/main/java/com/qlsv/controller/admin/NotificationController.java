package com.qlsv.controller.admin;

import com.qlsv.model.NotificationModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.INotificationService;
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

@WebServlet(urlPatterns = {"/admin-notification"})
public class NotificationController extends HttpServlet {
    @Inject
    private INotificationService notificationService;
    @Inject
    private IStudentService studentService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            List<NotificationModel> notificationModelList = notificationService.getAll();
            List<StudentModel> studentModelList = studentService.getAll();

            String typeSearch = req.getParameter("search");

            if(typeSearch != null && !typeSearch.equals("all")){
                StudentModel student = studentService.getOneByCode(typeSearch);
                studentModelList.removeIf(studentModel -> !(studentModel.getCode().equals(typeSearch)));
                notificationModelList.removeIf(noti -> noti.getStudentID() != student.getId());
            }

            req.setAttribute("notificationList", notificationModelList);
            req.setAttribute("studentList", studentModelList);
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/notification.jsp");
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            String studentCode = req.getParameter("studentCode");

           resp.sendRedirect(req.getContextPath() + "/admin-notification?search=" + studentCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
