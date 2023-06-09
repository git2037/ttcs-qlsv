package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.AccountModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements IRowMapper<AccountModel> {
    @Override
    public AccountModel map(ResultSet rs) {
        try {
            AccountModel accountModel = new AccountModel();

            accountModel.setId(rs.getInt("idTK"));
            accountModel.setUserName(rs.getString("tendangnhap"));
            accountModel.setPassword(rs.getString("matkhau"));
            accountModel.setRoleID(rs.getInt("idvt"));
            return accountModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
