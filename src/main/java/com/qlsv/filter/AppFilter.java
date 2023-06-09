package com.qlsv.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String role = (String) req.getSession().getAttribute("role");
        String url = req.getServletPath();

        if (url.contains("admin")) { // truy cap link admin
            if (role == null) { // chua dang nhap
                resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
            } else if (role.equals("student")){ // role student
                resp.sendRedirect(req.getContextPath() + "/error?code=403");
            } else if (role.equals("admin")){ // role admin
                chain.doFilter(req, resp);
            }

        } else if (url.equals("/index.jsp") || url.equals("/") || url.contains("/dang-nhap") || url.contains("/dang-xuat") ||
                url.contains("error") || url.contains("/template/web") || url.contains("/api")){ // link trang web thong thuong
            chain.doFilter(req, resp);

        } else { // trang sinh vien
            if (role == null) { // chua dang nhap
                resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login");
            } else if (role.equals("student")){ // role student
                chain.doFilter(req, resp);
            } else if (role.equals("admin")){ // role admin
                resp.sendRedirect(req.getContextPath() + "/error?code=403");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
