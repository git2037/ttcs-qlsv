package com.qlsv.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.AccountModel;
import com.qlsv.services.IAccountService;
import com.qlsv.utils.ApiUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/api-account")
public class AccountAPI extends HttpServlet {
    @Inject
    private IAccountService accountService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            ObjectMapper om = new ObjectMapper();
            AccountModel accountModel = ApiUtil.getInstance().toModel(req, AccountModel.class);
            accountService.insert(accountModel);
            om.writeValue(resp.getOutputStream(), accountModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("application/json");
            ObjectMapper om = new ObjectMapper();
            AccountModel accountModel = ApiUtil.getInstance().toModel(req, AccountModel.class);
            accountService.update(accountModel);
            om.writeValue(resp.getOutputStream(), accountModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
