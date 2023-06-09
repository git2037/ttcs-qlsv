package com.qlsv.services;

import com.qlsv.model.RoleModel;

public interface IRoleService extends IGenericService<RoleModel>{
    RoleModel getOneByID(int id);
    RoleModel getOneByCode(String code);
}
