package com.qlsv.dao;

import com.qlsv.model.CourseModel;

public interface ICourseDAO extends IAbstractDAO<CourseModel>{
    CourseModel getOneByCode(String code);
}
