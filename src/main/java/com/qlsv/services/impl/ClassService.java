package com.qlsv.services.impl;

import com.qlsv.dao.IClassDAO;
import com.qlsv.model.AbstractModel;
import com.qlsv.model.ClassModel;
import com.qlsv.services.IClassService;

import javax.inject.Inject;
import java.util.List;

public class ClassService implements IClassService {
    @Inject
    private IClassDAO classDAO;

    @Override
    public ClassModel getOneByID(int id) {
        return classDAO.getOneByID(id);
    }

    @Override
    public ClassModel getOneByCode(String code) {
        return classDAO.getOneByCode(code);
    }

    @Override
    public List<ClassModel> getAll() {
        return classDAO.getAll();
    }

    @Override
    public Integer insert(ClassModel classModel) {
        return classDAO.insert(classModel);
    }

    @Override
    public void update(ClassModel classModel) {
        classDAO.update(classModel);
    }

    @Override
    public void delete(int id) {
        classDAO.delete(id);
    }
}
