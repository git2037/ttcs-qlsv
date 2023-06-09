package com.qlsv.services;

import com.qlsv.model.StudentModel;

import java.util.List;

public interface IStudentService extends IGenericService<StudentModel>{
    List<StudentModel> getAllByClassID(int classID);
    StudentModel getOneByAccountID(int id);
    StudentModel getOneByID(int id);
    StudentModel getOneByCode(String code);
}
