package com.qlsv.services;

import com.qlsv.model.AdminModel;

import java.util.List;

public interface IAdminService extends IGenericService<AdminModel>{
    List<AdminModel> getAllByStatus(int status);
    AdminModel getOneByAccountID(int accountID);
}
