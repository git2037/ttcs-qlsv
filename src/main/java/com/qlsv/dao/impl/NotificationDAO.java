package com.qlsv.dao.impl;

import com.qlsv.dao.INotificationDAO;
import com.qlsv.mapper.impl.NotificationMapper;
import com.qlsv.model.NotificationModel;

import java.util.List;

public class NotificationDAO extends AbstractDAO<NotificationModel> implements INotificationDAO {
    @Override
    public List<NotificationModel> getAll() {
        String sql = "SELECT * FROM thongbao ORDER BY trangThai;";
        return query(sql, new NotificationMapper());
    }

    @Override
    public NotificationModel getOneByID(int id) {
        String sql = "SELECT * FROM thongbao WHERE idtb = ?";
        List<NotificationModel> list = query(sql, new NotificationMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public Integer insert(NotificationModel n) {
        String sql = "INSERT INTO thongbao(noidung, trangthai, idad, idsv) VALUES (?, ?, ?, ?)";
        return insert(sql, n.getContent(), n.getStatus(), n.getAdminID(), n.getStudentID());
    }

    @Override
    public void update(NotificationModel n) {
        String sql = ("UPDATE thongbao SET trangthai = ? WHERE idtb = ?");
        update(sql, n.getStatus(), n.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM thongbao WHERE idtb = ?";
        update(sql, id);
    }

    @Override
    public List<NotificationModel> getAllByAdminID(int id) {
        String sql = "SELECT * FROM thongbao WHERE idad = ?";
        return query(sql, new NotificationMapper(), id);
    }

    @Override
    public List<NotificationModel> getAllByStudentID(int id) {
        String sql = "SELECT * FROM thongbao WHERE idsv = ?";
        return query(sql, new NotificationMapper(), id);
    }

    @Override
    public List<NotificationModel> getAllByStatus(int status) {
        String sql = "SELECT * FROM thongbao WHERE trangthai = ?";
        return query(sql, new NotificationMapper(), status);
    }
}
