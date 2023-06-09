package com.qlsv.dao;

import com.qlsv.model.AdminModel;

import java.util.List;

public interface IAdminDAO extends IAbstractDAO<AdminModel>{
    AdminModel getOneByID(int id);
    AdminModel getOneByAccountID(int id);
    List<AdminModel> getAllByStatus(int status);
}
