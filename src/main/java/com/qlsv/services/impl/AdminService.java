package com.qlsv.services.impl;

import com.qlsv.dao.IAdminDAO;
import com.qlsv.model.AdminModel;
import com.qlsv.services.IAdminService;

import javax.inject.Inject;
import java.util.List;

public class AdminService implements IAdminService {
    @Inject
    private IAdminDAO adminDAO;
    @Override
    public List<AdminModel> getAllByStatus(int status) {
        return adminDAO.getAllByStatus(status);
    }

    @Override
    public AdminModel getOneByAccountID(int accountID) {
        return adminDAO.getOneByAccountID(accountID);
    }

    @Override
    public List<AdminModel> getAll() {
        return adminDAO.getAll();
    }

    @Override
    public Integer insert(AdminModel adminModel) {
        return adminDAO.insert(adminModel);
    }

    @Override
    public void update(AdminModel adminModel) {
        adminDAO.update(adminModel);
    }

    @Override
    public void delete(int id) {
        adminDAO.delete(id);
    }
}
