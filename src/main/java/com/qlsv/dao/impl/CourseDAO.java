package com.qlsv.dao.impl;

import com.qlsv.dao.ICourseDAO;
import com.qlsv.mapper.impl.CourseMapper;
import com.qlsv.model.CourseModel;

import java.util.List;

public class CourseDAO extends AbstractDAO<CourseModel> implements ICourseDAO {
    @Override
    public List<CourseModel> getAll() {
        String sql = "SELECT * FROM khoahoc";
        return query(sql, new CourseMapper());
    }

    @Override
    public CourseModel getOneByID(int id) {
        String sql = "SELECT * FROM khoahoc WHERE idkh = ?";
        List<CourseModel> list = query(sql, new CourseMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(CourseModel courseModel) {
        String sql = "INSERT INTO khoahoc(makh) VALUES (?)";
        return insert(sql, courseModel.getCode());
    }

    @Override
    public void update(CourseModel courseModel) {
        String sql = ("UPDATE khoaHoc SET maKH = ? WHERE idkh = ?");
        update(sql, courseModel.getCode(), courseModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM khoahoc WHERE idkh = ?";
        update(sql, id);
    }

    @Override
    public CourseModel getOneByCode(String code) {
        String sql = "SELECT * FROM khoahoc WHERE makh = ?";
        List<CourseModel> list = query(sql, new CourseMapper(), code);
        return list.size() == 1 ? list.get(0) : null;
    }
}
