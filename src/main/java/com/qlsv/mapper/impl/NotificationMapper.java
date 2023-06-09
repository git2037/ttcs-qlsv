package com.qlsv.mapper.impl;

import com.qlsv.mapper.IRowMapper;
import com.qlsv.model.NotificationModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationMapper implements IRowMapper<NotificationModel> {
    @Override
    public NotificationModel map(ResultSet rs) {
        try {
            NotificationModel notificationModel = new NotificationModel();

            notificationModel.setId(rs.getInt("idTB"));
            notificationModel.setContent(rs.getString("noiDung"));
            notificationModel.setAdminID(rs.getInt("idad"));
            notificationModel.setStatus(rs.getInt("trangThai"));
            notificationModel.setStudentID(rs.getInt("idsv"));

            return notificationModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
