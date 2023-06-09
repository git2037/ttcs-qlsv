package com.qlsv.services;

import com.qlsv.model.ScoreModel;

import java.util.List;

public interface IScoreService extends IGenericService<ScoreModel>{
    List<ScoreModel> getAllByStudentID(int studentID);
    List<ScoreModel> getAllBySubjectID(int subjectID);
    ScoreModel getOneByID(int id);
    double calculateGPA(int studentID);
}
