package com.qlsv.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
    T map(ResultSet rs);
}
