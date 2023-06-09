package com.qlsv.dao.impl;

import com.qlsv.dao.IStudentDAO;
import com.qlsv.mapper.impl.StudentMapper;
import com.qlsv.model.StudentModel;

import java.util.List;

public class StudentDAO extends AbstractDAO<StudentModel> implements IStudentDAO {
    @Override
    public List<StudentModel> getAll() {
        String sql = "SELECT * FROM sinhvien";
        return query(sql, new StudentMapper());
    }

    @Override
    public StudentModel getOneByID(int id) {
        String sql = "SELECT * FROM sinhvien WHERE idsv = ?";
        List<StudentModel> list = query(sql, new StudentMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(StudentModel s) {
        StringBuilder sb;
        sb = new StringBuilder("INSERT INTO sinhvien(masv, hovaten, gioitinh, diachi, ngaysinh, trangthai,");
        sb.append("idlh, idtk)");
        sb.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sb.toString(), s.getCode(), s.getFullname(), s.getGender(), s.getAddress(), s.getDob(),
                s.getStatus(), s.getClassID(), s.getAccountID());
    }

    @Override
    public void update(StudentModel s) {
        StringBuilder sb;
        sb = new StringBuilder("UPDATE sinhvien SET masv = ?, hoVaTen = ?, gioiTinh = ?,");
        sb.append("diaChi = ?, ngaySinh = ?, trangThai = ?, idlh = ? WHERE idSV = ?");
        update(sb.toString(), s.getCode(), s.getFullname(), s.getGender(), s.getAddress(), s.getDob(),
                s.getStatus(), s.getClassID(), s.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM sinhvien WHERE idsv = ?";
        update(sql, id);
    }

    @Override
    public List<StudentModel> getAllByClassID(int id) {
        String sql = "SELECT * FROM sinhvien where idlh = ?";
        return query(sql, new StudentMapper(), id);
    }

    @Override
    public StudentModel getOneByAccountID(int id) {
        String sql = "SELECT * FROM sinhvien WHERE idtk = ?";
        List<StudentModel> list = query(sql, new StudentMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public StudentModel getOneByCode(String code) {
        String sql = "SELECT * FROM sinhvien WHERE masv = ?";
        List<StudentModel> list = query(sql, new StudentMapper(), code);
        return list.size() == 1 ? list.get(0) : null;
    }
}
