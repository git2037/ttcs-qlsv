package com.qlsv.dao.impl;

import com.qlsv.dao.IGenericDAO;
import com.qlsv.mapper.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AbstractDAO<T> implements IGenericDAO<T> {
    public static final String NULL_CONNECTION = "Connection is null!";
    public static Connection getConnection() {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("db");
            String driver = rb.getString("driver");
            String url = rb.getString("url");
            String user = rb.getString("user");
            String password = rb.getString("password");
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
        List<T> listResult = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (con != null) {
                ps = con.prepareStatement(sql);
                setParameters(ps, parameters);
                rs = ps.executeQuery();

                while (rs.next()) {
                    T object = rowMapper.map(rs);
                    listResult.add(object);
                }
            } else {
                System.err.println(NULL_CONNECTION);
            }
            return listResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return listResult;
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer insert(String sql, Object... parameters) {
        Integer key = null;
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (con != null) {
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                setParameters(ps, parameters);
                int row = ps.executeUpdate();
                rs = ps.getGeneratedKeys();

                if (row == 1) {
                    while (rs.next()){
                        key = rs.getInt(1);
                    }
                } else {
                    System.err.println("Insert Failed!");
                }
            } else {
                System.err.println(NULL_CONNECTION);
            }
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        try {
            if (con != null) {
                ps = con.prepareStatement(sql);
                setParameters(ps, parameters);
                int row = ps.executeUpdate();

                if (row != 1) {
                    System.err.println("Update Failed!");
                }
            } else {
                System.err.println(NULL_CONNECTION);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            int index = i + 1;
            ps.setObject(index, parameters[i]);
        }
    }
}
