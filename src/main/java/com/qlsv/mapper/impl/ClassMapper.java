package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.ClassModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassMapper implements IRowMapper<ClassModel> {
    @Override
    public ClassModel map(ResultSet rs) {
        try {
            ClassModel classModel = new ClassModel();

            classModel.setId(rs.getInt("idLH"));
            classModel.setCode(rs.getString("malh"));
            classModel.setName(rs.getString("tenLH"));
            classModel.setCourseID(rs.getInt("idKH"));

            return classModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
