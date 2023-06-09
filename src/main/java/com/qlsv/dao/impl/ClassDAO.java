package com.qlsv.dao.impl;

import com.qlsv.dao.IClassDAO;
import com.qlsv.mapper.impl.ClassMapper;
import com.qlsv.model.ClassModel;

import java.util.List;

public class ClassDAO extends AbstractDAO<ClassModel> implements IClassDAO {
    @Override
    public List<ClassModel> getAll() {
        String sql = "SELECT * FROM lophoc";
        return query(sql, new ClassMapper());
    }

    @Override
    public ClassModel getOneByID(int id) {
        String sql = "SELECT * FROM lophoc WHERE idlh = ?";
        List<ClassModel> list = query(sql, new ClassMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(ClassModel classModel) {
        String sql = "INSERT INTO lophoc(malh, tenlh, idkh) VALUES (?, ?, ?)";
        return insert(sql, classModel.getCode(), classModel.getName(), classModel.getCourseID());
    }

    @Override
    public void update(ClassModel classModel) {
        String sql = ("UPDATE lophoc SET tenlh = ?, idkh = ? WHERE idlh = ?");
        update(sql, classModel.getName(), classModel.getCourseID(), classModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM lophoc WHERE idlh = ?";
        update(sql, id);
    }

    @Override
    public ClassModel getOneByCode(String code) {
        String sql = "SELECT * FROM lophoc WHERE malh = ?";
        List<ClassModel> list = query(sql, new ClassMapper(), code);
        return list.size() == 1 ? list.get(0) : null;
    }
}
