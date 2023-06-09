package com.qlsv.dao.impl;

import com.qlsv.dao.ISubjectDAO;
import com.qlsv.mapper.impl.SubjectMapper;
import com.qlsv.model.SubjectModel;

import java.util.List;

public class SubjectDAO extends AbstractDAO<SubjectModel> implements ISubjectDAO {
    @Override
    public List<SubjectModel> getAll() {
        String sql = "SELECT * FROM hocPhan ";
        return query(sql, new SubjectMapper());
    }

    @Override
    public SubjectModel getOneByID(int id) {
        String sql = "SELECT * FROM hocPhan WHERE idHP = ?";
        List<SubjectModel> list = query(sql, new SubjectMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(SubjectModel subjectModel) {
        String sql = "INSERT INTO hocPhan(mahp, tenhp, sotinchi) VALUES (?, ?, ?)";
        return insert(sql, subjectModel.getCode(), subjectModel.getName(), subjectModel.getCredit());
    }

    @Override
    public void update(SubjectModel subjectModel) {
        String sql = ("UPDATE hocPhan SET maHP = ?, tenHP = ?, soTinChi = ? WHERE idHP = ?");
        update(sql, subjectModel.getCode(), subjectModel.getName(), subjectModel.getCredit(),
                subjectModel.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM hocPhan WHERE idHP = ?";
        update(sql, id);
    }

    @Override
    public SubjectModel getOneByCode(String code) {
        String sql = "SELECT * FROM hocPhan WHERE mahp = ?";
        List<SubjectModel> list = query(sql, new SubjectMapper(), code);
        return list.size() == 1 ? list.get(0) : null;
    }
}
