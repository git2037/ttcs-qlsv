package com.qlsv.dao;

import com.qlsv.mapper.IRowMapper;

import java.util.List;

public interface IGenericDAO<T> {
    List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
    Integer insert(String sql, Object... parameters);
    void update(String sql, Object... parameters);
}
