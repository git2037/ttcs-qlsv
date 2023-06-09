package com.qlsv.dao;

import com.qlsv.model.AccountModel;

import java.sql.SQLException;

public interface IAccountDAO extends IAbstractDAO<AccountModel>{
    AccountModel getOneByUserNameAndPassword(String userName, String password) throws SQLException;
}
