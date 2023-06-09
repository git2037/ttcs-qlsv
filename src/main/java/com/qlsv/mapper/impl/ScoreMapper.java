package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.ScoreModel;
import com.qlsv.model.SubjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreMapper implements IRowMapper<ScoreModel> {
    @Override
    public ScoreModel map(ResultSet rs) {
        try {
            ScoreModel scoreModel = new ScoreModel();
            scoreModel.setId(rs.getInt("idD"));
            scoreModel.setScore1(rs.getDouble("diemGK"));
            scoreModel.setScore2(rs.getDouble("diemCC"));
            scoreModel.setScore3(rs.getDouble("diemCK"));
            scoreModel.setTotalScore(rs.getDouble("diemTK"));
            scoreModel.setStudentID(rs.getInt("idsv"));
            scoreModel.setSubjectID(rs.getInt("idhp"));

            try {
                SubjectModel subjectModel = new SubjectModel();
                subjectModel.setCredit(rs.getInt("soTinChi"));
                scoreModel.setSubjectModel(subjectModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return scoreModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
