package com.qlsv.services;

import java.util.List;

public interface IGenericService<T> {
    List<T> getAll();
    Integer insert(T t);
    void update(T t);
    void delete(int id);
}
