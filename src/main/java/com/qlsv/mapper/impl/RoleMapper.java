package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements IRowMapper<RoleModel> {
    @Override
    public RoleModel map(ResultSet rs) {
        try {
            RoleModel roleModel = new RoleModel();

            roleModel.setId(rs.getInt("idVT"));
            roleModel.setCode(rs.getString("maVT"));
            roleModel.setName(rs.getString("tenVT"));

            return roleModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
