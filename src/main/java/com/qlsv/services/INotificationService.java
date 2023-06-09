package com.qlsv.services;

import com.qlsv.model.NotificationModel;

import java.util.List;

public interface INotificationService extends IGenericService<NotificationModel>{
    List<NotificationModel> getAllByAdminID(int id);
    List<NotificationModel> getAllByStudentID(int id);
    List<NotificationModel> getAllByStatus(int status);
}
