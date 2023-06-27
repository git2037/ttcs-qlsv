package com.qlsv.services.impl;

import com.qlsv.dao.IAccountDAO;
import com.qlsv.dao.IClassDAO;
import com.qlsv.dao.IRoleDAO;
import com.qlsv.dao.IStudentDAO;
import com.qlsv.model.AccountModel;
import com.qlsv.model.ClassModel;
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
    @Inject
    private IClassDAO classDAO;
    @Override
    public List<StudentModel> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Integer insert(StudentModel studentModel) {
        // insert account
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

        // insert student information
        ClassModel classModel = findClassModelByClassNameInClassList(studentModel.getClassName(), classDAO.getAll());
        String last = String.format("%02d", Integer.parseInt(studentModel.getCode()));
        String studentCode = classModel.getCode().concat(last);
        studentModel.setCode(studentCode);
        studentModel.setClassID(classModel.getId());
        studentModel.setStatus(1);

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

    public ClassModel findClassModelByClassNameInClassList(String className, List<ClassModel> classList) {
        for (ClassModel classModel : classList) {
            if (classModel.getName().equals(className)) {
                return classModel;
            }
        }
        return null;
    }
}
