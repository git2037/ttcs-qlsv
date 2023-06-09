package com.qlsv.services;

import com.qlsv.model.CourseModel;

public interface ICourseService extends IGenericService<CourseModel>{
    CourseModel getOneByCode(String code);
}
