package com.qlsv.services;

import com.qlsv.model.SubjectModel;

public interface ISubjectService extends IGenericService<SubjectModel>{
    SubjectModel getOneByCode(String code);
    SubjectModel getOneByID(int id);
}
