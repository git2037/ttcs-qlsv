package com.qlsv.services.impl;

import com.qlsv.dao.IScoreDAO;
import com.qlsv.model.ScoreModel;
import com.qlsv.services.IScoreService;

import javax.inject.Inject;
import java.util.List;

public class ScoreService implements IScoreService {
    @Inject
    private IScoreDAO scoreDAO;

    public void setTotalScore(ScoreModel scoreModel){
        double score1 = scoreModel.getScore1();
        double score2 = scoreModel.getScore2();
        double score3 = scoreModel.getScore3();
        double total = (score1 * 0.7 + score2 * 0.3) * 0.3 + score3 * 0.7;
        double totalScore = Math.round(total * 10.0) / 10.0;
        scoreModel.setTotalScore(totalScore);
    }

    @Override
    public List<ScoreModel> getAll() {
        return scoreDAO.getAll();
    }

    @Override
    public Integer insert(ScoreModel scoreModel) {
        setTotalScore(scoreModel);
        return scoreDAO.insert(scoreModel);
    }

    @Override
    public void update(ScoreModel scoreModel) {
        setTotalScore(scoreModel);
        scoreDAO.update(scoreModel);
    }

    @Override
    public void delete(int id) {
        scoreDAO.delete(id);
    }

    @Override
    public List<ScoreModel> getAllByStudentID(int studentID) {
        return scoreDAO.getAllByStudentID(studentID);
    }

    @Override
    public List<ScoreModel> getAllBySubjectID(int subjectID) {
        return scoreDAO.getAllBySubjectID(subjectID);
    }

    @Override
    public ScoreModel getOneByID(int id) {
        return scoreDAO.getOneByID(id);
    }

    @Override
    public double calculateGPA(int studentID) {
        List<ScoreModel> scoreList = scoreDAO.getAllByStudentID(studentID);
        double gpa = 0;
        int totalCredit = 0;
        for(ScoreModel scoreModel : scoreList) {
            int credit = scoreModel.getSubjectModel().getCredit();
            gpa += scoreModel.getTotalScore() * credit;
            totalCredit += credit;
        }

        if (totalCredit != 0) {
            gpa = ((gpa / 10) * 4) / totalCredit;
            gpa = Math.round(gpa * 100.0) / 100.0;
        }

        return gpa;
    }
}
