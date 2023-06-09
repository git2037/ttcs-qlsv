package com.qlsv.services;

import com.qlsv.model.ClassModel;

public interface IClassService extends IGenericService<ClassModel>{
    ClassModel getOneByID(int id);
    ClassModel getOneByCode(String code);
}
