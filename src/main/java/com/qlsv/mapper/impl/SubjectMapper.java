package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.SubjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper implements IRowMapper<SubjectModel> {
    @Override
    public SubjectModel map(ResultSet rs) {
        try {
            SubjectModel subjectModel = new SubjectModel();

            subjectModel.setId(rs.getInt("idHP"));
            subjectModel.setCode(rs.getString("maHP"));
            subjectModel.setName(rs.getString("tenHP"));
            subjectModel.setCredit(rs.getInt("soTinChi"));

            return subjectModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
