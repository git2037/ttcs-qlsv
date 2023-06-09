package com.qlsv.dao;

import com.qlsv.model.NotificationModel;

import java.util.List;

public interface INotificationDAO extends IAbstractDAO<NotificationModel>{
    List<NotificationModel> getAllByAdminID(int id);
    List<NotificationModel> getAllByStudentID(int id);
    List<NotificationModel> getAllByStatus(int status);
}
