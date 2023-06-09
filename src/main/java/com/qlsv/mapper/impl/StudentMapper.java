package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.StudentModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements IRowMapper<StudentModel> {
    @Override
    public StudentModel map(ResultSet rs) {
        try {
            StudentModel studentModel = new StudentModel();

            studentModel.setId(rs.getInt("idSV"));
            studentModel.setCode(rs.getString("maSV"));
            studentModel.setFullname(rs.getString("hoVaTen"));
            studentModel.setGender(rs.getString("gioiTinh"));
            studentModel.setAddress(rs.getString("diaChi"));
            studentModel.setDob(rs.getDate("ngaySinh"));
            studentModel.setStatus(rs.getInt("trangThai"));
            studentModel.setClassID(rs.getInt("idlh"));
            studentModel.setAccountID(rs.getInt("idtk"));

            return studentModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
