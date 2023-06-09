package com.qlsv.services.impl;

import com.qlsv.dao.IRoleDAO;
import com.qlsv.model.RoleModel;
import com.qlsv.services.IRoleService;

import javax.inject.Inject;
import java.util.List;

public class RoleService implements IRoleService {
    @Inject
    private IRoleDAO roleDAO;
    @Override
    public List<RoleModel> getAll() {
        return roleDAO.getAll();
    }

    @Override
    public Integer insert(RoleModel roleModel) {
        return roleDAO.insert(roleModel);
    }

    @Override
    public void update(RoleModel roleModel) {
        roleDAO.update(roleModel);
    }

    @Override
    public void delete(int id) {
        roleDAO.delete(id);
    }

    @Override
    public RoleModel getOneByID(int id) {
        return roleDAO.getOneByID(id);
    }

    @Override
    public RoleModel getOneByCode(String code) {
        return roleDAO.getOneByCode(code);
    }
}
