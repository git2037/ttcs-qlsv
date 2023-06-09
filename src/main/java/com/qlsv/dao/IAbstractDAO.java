package com.qlsv.dao;

import java.util.List;

public interface IAbstractDAO<T> extends IGenericDAO<T>{
    List<T> getAll();
    T getOneByID(int id);
    Integer insert(T t);
    void update(T t);
    void delete(int id);
}
