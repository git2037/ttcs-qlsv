package com.qlsv.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlsv.model.ClassModel;
import com.qlsv.model.StudentModel;
import com.qlsv.services.IClassService;
import com.qlsv.services.IStudentService;
import com.qlsv.utils.ApiUtil;
import com.qlsv.utils.CommonUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/api-student"})
public class StudentAPI extends HttpServlet {
    @Inject
    private IStudentService studentService;
    @Inject
    private IClassService classService;

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<ClassModel> classList = classService.getAll();
            resp.setContentType("application/json");
            StudentModel studentModel = ApiUtil.getInstance().toModel(req, StudentModel.class);
            ClassModel classModel = CommonUtils.getInstance().findClassModelByClassNameInClassList(studentModel.getClassName(), classList);

            String last = String.format("%02d", Integer.parseInt(studentModel.getCode()));
            String studentCode = classModel.getCode().concat(last);
            studentModel.setCode(studentCode);
            studentModel.setClassID(classModel.getId());
            studentModel.setStatus(1);

            studentService.insert(studentModel);
            new ObjectMapper().writeValue(resp.getOutputStream(), studentModel);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<ClassModel> classList = classService.getAll();
            resp.setContentType("application/json");
            ObjectMapper om = new ObjectMapper();
            StudentModel studentModel = ApiUtil.getInstance().toModel(req, StudentModel.class);
            ClassModel classModel = CommonUtils.getInstance().findClassModelByClassNameInClassList(studentModel.getClassName(), classList);

            studentModel.setClassID(classModel.getId());
            studentService.update(studentModel);
            om.writeValue(resp.getOutputStream(), studentModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
