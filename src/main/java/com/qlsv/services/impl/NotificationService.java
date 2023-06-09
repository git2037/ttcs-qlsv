package com.qlsv.services.impl;

import com.qlsv.dao.INotificationDAO;
import com.qlsv.model.NotificationModel;
import com.qlsv.services.INotificationService;

import javax.inject.Inject;
import java.util.List;

public class NotificationService implements INotificationService {
    @Inject
    private INotificationDAO notificationDAO;
    @Override
    public List<NotificationModel> getAll() {
        return notificationDAO.getAll();
    }

    @Override
    public Integer insert(NotificationModel notificationModel) {
        return notificationDAO.insert(notificationModel);
    }

    @Override
    public void update(NotificationModel notificationModel) {
        notificationDAO.update(notificationModel);
    }

    @Override
    public void delete(int id) {
        notificationDAO.delete(id);
    }

    @Override
    public List<NotificationModel> getAllByAdminID(int id) {
        return notificationDAO.getAllByAdminID(id);
    }

    @Override
    public List<NotificationModel> getAllByStudentID(int id) {
        return notificationDAO.getAllByStudentID(id);
    }

    @Override
    public List<NotificationModel> getAllByStatus(int status) {
        return notificationDAO.getAllByStatus(status);

    }
}
