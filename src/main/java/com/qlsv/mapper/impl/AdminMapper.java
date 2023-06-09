package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.AdminModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements IRowMapper<AdminModel> {
    @Override
    public AdminModel map(ResultSet rs) {
        try {
            AdminModel adminModel = new AdminModel();
            adminModel.setId(rs.getInt("idAD"));
            adminModel.setCode(rs.getString("maAD"));
            adminModel.setFullname(rs.getString("hovaten"));
            adminModel.setGender(rs.getString("gioitinh"));
            adminModel.setAddress(rs.getString("diachi"));
            adminModel.setDob(rs.getDate("ngaysinh"));
            adminModel.setStatus(rs.getInt("trangthai"));
            adminModel.setAccountID(rs.getInt("idtk"));

            return adminModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
