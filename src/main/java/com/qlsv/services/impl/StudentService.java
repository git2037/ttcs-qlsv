package com.qlsv.services.impl;

import com.qlsv.dao.IAccountDAO;
import com.qlsv.dao.IRoleDAO;
import com.qlsv.dao.IStudentDAO;
import com.qlsv.model.AccountModel;
import com.qlsv.model.RoleModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.IStudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentService implements IStudentService {
    @Inject
    private IStudentDAO studentDAO;
    @Inject
    private IAccountDAO accountDAO;
    @Inject
    private IRoleDAO roleDAO;
    @Override
    public List<StudentModel> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Integer insert(StudentModel studentModel) {
        AccountModel accountModel = new AccountModel();
        accountModel.setUserName(studentModel.getCode());
        accountModel.setPassword("123456");
        List<RoleModel> list = roleDAO.getAll();

        for (RoleModel roleModel : list) {
            if (roleModel.getCode().equals("student")) {
                accountModel.setRoleID(roleModel.getId());
                break;
            }
        }
        int accID = accountDAO.insert(accountModel);
        studentModel.setAccountID(accID);
        return studentDAO.insert(studentModel);
    }

    @Override
    public void update(StudentModel studentModel) {
        studentDAO.update(studentModel);
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }

    @Override
    public List<StudentModel> getAllByClassID(int classID) {
        return studentDAO.getAllByClassID(classID);
    }

    @Override
    public StudentModel getOneByAccountID(int id) {
        return studentDAO.getOneByAccountID(id);
    }

    @Override
    public StudentModel getOneByID(int id) {
        return studentDAO.getOneByID(id);
    }

    @Override
    public StudentModel getOneByCode(String code) {
        return studentDAO.getOneByCode(code);
    }
}
