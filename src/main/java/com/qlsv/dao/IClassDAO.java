package com.qlsv.dao;

import com.qlsv.model.ClassModel;

public interface IClassDAO extends IAbstractDAO<ClassModel>{
    ClassModel getOneByCode(String code);
}
