package com.qlsv.services.impl;

import com.qlsv.dao.ISubjectDAO;
import com.qlsv.model.SubjectModel;
import com.qlsv.services.ISubjectService;

import javax.inject.Inject;
import java.util.List;

public class SubjectService implements ISubjectService {
    @Inject
    private ISubjectDAO subjectDAO;
    @Override
    public List<SubjectModel> getAll() {
        return subjectDAO.getAll();
    }

    @Override
    public Integer insert(SubjectModel subjectModel) {
        return subjectDAO.insert(subjectModel);
    }

    @Override
    public void update(SubjectModel subjectModel) {
        subjectDAO.update(subjectModel);
    }

    @Override
    public void delete(int id) {
        subjectDAO.delete(id);
    }

    @Override
    public SubjectModel getOneByCode(String code) {
        return subjectDAO.getOneByCode(code);
    }

    @Override
    public SubjectModel getOneByID(int id) {
        return subjectDAO.getOneByID(id);
    }
}
