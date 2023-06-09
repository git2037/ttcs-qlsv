package com.qlsv.dao;

import com.qlsv.model.StudentModel;

import java.util.List;

public interface IStudentDAO extends IAbstractDAO<StudentModel>{
    List<StudentModel> getAllByClassID(int id);
    StudentModel getOneByAccountID(int id);
    StudentModel getOneByCode(String code);
}
