package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.NotificationModel;
import com.qlsv.services.INotificationService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api-notification")
public class NotificationAPI extends HttpServlet {
    @Inject
    private INotificationService notificationService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            NotificationModel notificationModel = ApiUtil.getInstance().toModel(req, NotificationModel.class);
            notificationModel.setStatus(0);
            notificationService.insert(notificationModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), notificationModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            NotificationModel notificationModel = ApiUtil.getInstance().toModel(req, NotificationModel.class);
            ServletContext servletContext = req.getServletContext();
            int number = (int) servletContext.getAttribute("numberOfNewNotification");

            number--;
            servletContext.setAttribute("numberOfNewNotification", number);
            notificationService.update(notificationModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), notificationModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
