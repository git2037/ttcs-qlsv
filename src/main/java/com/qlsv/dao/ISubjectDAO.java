package com.qlsv.dao;

import com.qlsv.model.SubjectModel;

public interface ISubjectDAO extends IAbstractDAO<SubjectModel>{
    SubjectModel getOneByCode(String code);
}
