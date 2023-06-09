package com.qlsv.dao;

import com.qlsv.model.RoleModel;

public interface IRoleDAO extends IAbstractDAO<RoleModel>{
    RoleModel getOneByCode(String code);
}
