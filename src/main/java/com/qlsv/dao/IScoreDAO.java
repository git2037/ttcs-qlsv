package com.qlsv.dao;

import com.qlsv.model.ScoreModel;

import java.util.List;

public interface IScoreDAO extends IAbstractDAO<ScoreModel>{
    ScoreModel getOneByID(int id);
    List<ScoreModel> getAllByStudentID(int id);
    List<ScoreModel> getAllBySubjectID(int id);
}
