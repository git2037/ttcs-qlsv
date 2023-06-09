package com.qlsv.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/error")
public class ErrorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String error = req.getParameter("code");

            if (error.equals("403")) {
                RequestDispatcher rd = req.getRequestDispatcher("/views/web/403.jsp");
                rd.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}