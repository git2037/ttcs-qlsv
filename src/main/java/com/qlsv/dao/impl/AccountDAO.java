package com.qlsv.dao.impl;

import com.qlsv.dao.IAccountDAO;
import com.qlsv.mapper.impl.AccountMapper;
import com.qlsv.model.AccountModel;

import java.util.List;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO {
    @Override
    public List<AccountModel> getAll() {
        String sql = "SELECT * FROM taikhoan";
        return query(sql, new AccountMapper());
    }

    @Override
    public AccountModel getOneByID(int id) {
        String sql = "SELECT * FROM taikhoan WHERE idtk = ?";
        List<AccountModel> list = query(sql, new AccountMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(AccountModel accountModel) {
        String sql = "INSERT INTO taikhoan(tendangnhap, matkhau, idvt) VALUES (?, ?, ?)";
        return insert(sql, accountModel.getUserName(), accountModel.getPassword(), accountModel.getRoleID());
    }

    @Override
    public void update(AccountModel accountModel) {
        String sql = ("UPDATE taikhoan SET matkhau = ? WHERE idTK = ?");
        update(sql, accountModel.getPassword(), accountModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM taikhoan WHERE idtk = ?";
        update(sql, id);
    }

    @Override
    public AccountModel getOneByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM taikhoan WHERE tendangnhap = ? and matkhau = ?";
        List<AccountModel> list = query(sql, new AccountMapper(), userName, password);
        return list.size() == 1 ? list.get(0) : null;
    }
}
