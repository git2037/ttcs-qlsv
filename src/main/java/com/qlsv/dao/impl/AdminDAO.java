package com.qlsv.dao.impl;

import com.qlsv.dao.IAdminDAO;
import com.qlsv.mapper.impl.AdminMapper;
import com.qlsv.model.AdminModel;

import java.util.List;

public class AdminDAO extends AbstractDAO<AdminModel> implements IAdminDAO {
    @Override
    public List<AdminModel> getAll() {
        String sql = "SELECT * FROM admin";
        return query(sql, new AdminMapper());
    }

    @Override
    public Integer insert(AdminModel admin) {
        String sql = "INSERT INTO admin(maad, hovaten, gioitinh, diachi, ngaysinh, trangthai, idtk)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, admin.getCode(), admin.getFullname(), admin.getGender(), admin.getAddress(),
                        admin.getDob(), admin.getStatus(), admin.getAccountID());
    }

    @Override
    public void update(AdminModel admin) {
        StringBuilder sb;
        sb = new StringBuilder("UPDATE admin SET maAD = ?, hoVaTen = ?, gioiTinh = ?,");
        sb.append("diaChi = ?, ngaySinh = ?, trangThai = ? WHERE idAD = ?");
        update(sb.toString(), admin.getCode(), admin.getFullname(), admin.getGender(), admin.getAddress(),
                admin.getDob(), admin.getStatus(), admin.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM admin WHERE idAD = ?";
        update(sql, id);
    }

    @Override
    public AdminModel getOneByID(int id) {
        String sql = "SELECT * FROM admin WHERE idAD = ?";
        List<AdminModel> list = query(sql, new AdminMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public AdminModel getOneByAccountID(int id) {
        String sql = "SELECT * FROM admin WHERE idTK = ?";
        List<AdminModel> list = query(sql, new AdminMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<AdminModel> getAllByStatus(int status) {
        String sql = "SELECT * FROM admin where trangthai = ?";
        return query(sql, new AdminMapper(), status);
    }
}
