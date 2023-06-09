package com.qlsv.dao.impl;

import com.qlsv.dao.IRoleDAO;
import com.qlsv.mapper.impl.RoleMapper;
import com.qlsv.model.RoleModel;

import java.util.List;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {
    @Override
    public List<RoleModel> getAll() {
        String sql = "SELECT * FROM vaitro";
        return query(sql, new RoleMapper());
    }

    @Override
    public RoleModel getOneByID(int id) {
        String sql = "SELECT * FROM vaitro WHERE idvt = ?";
        List<RoleModel> list = query(sql, new RoleMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(RoleModel roleModel) {
        String sql = "INSERT INTO vaitro(mavt, tenvt) VALUES (?, ?)";
        return insert(sql, roleModel.getCode(), roleModel.getName());
    }

    @Override
    public void update(RoleModel roleModel) {
        String sql = ("UPDATE vaitro SET mavt = ?, tenvt = ? WHERE idvt = ?");
        update(sql, roleModel.getCode(), roleModel.getName(), roleModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM vaitro WHERE idvt = ?";
        update(sql, id);
    }

    @Override
    public RoleModel getOneByCode(String code) {
        String sql = "SELECT * FROM hocPhan WHERE mavt = ?";
        List<RoleModel> list = query(sql, new RoleMapper(), code);
        return list.size() == 1 ? list.get(0) : null;
    }
}
