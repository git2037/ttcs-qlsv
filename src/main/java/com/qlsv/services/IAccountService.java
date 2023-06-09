package com.qlsv.services;

import com.qlsv.model.AccountModel;

import java.sql.SQLException;

public interface IAccountService extends IGenericService<AccountModel>{
    AccountModel getOneByUserNameAndPassword(String userName, String password) throws SQLException;
    AccountModel getOneByID(int id);
}
