package com.qlsv.services.impl;

import com.qlsv.dao.IAccountDAO;
import com.qlsv.model.AccountModel;
import com.qlsv.services.IAccountService;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService {
    @Inject
    private IAccountDAO accountDAO;
    @Override
    public AccountModel getOneByUserNameAndPassword(String userName, String password) {
        try {
            return accountDAO.getOneByUserNameAndPassword(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccountModel getOneByID(int id) {
        return accountDAO.getOneByID(id);
    }

    @Override
    public List<AccountModel> getAll() {
        return accountDAO.getAll();
    }

    @Override
    public Integer insert(AccountModel accountModel) {
        return accountDAO.insert(accountModel);
    }

    @Override
    public void update(AccountModel accountModel) {
        accountDAO.update(accountModel);
    }

    @Override
    public void delete(int id) {
        accountDAO.delete(id);
    }
}
