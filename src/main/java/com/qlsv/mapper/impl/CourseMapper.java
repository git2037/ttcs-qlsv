package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.CourseModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements IRowMapper<CourseModel> {
    @Override
    public CourseModel map(ResultSet rs) {
        try {
            CourseModel courseModel = new CourseModel();

            courseModel.setId(rs.getInt("idKH"));
            courseModel.setCode(rs.getString("maKH"));

            return courseModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
