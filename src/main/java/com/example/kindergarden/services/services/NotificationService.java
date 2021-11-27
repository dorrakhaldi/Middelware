package com.example.kindergarden.services.services;

import java.util.Date;
import java.util.List;

import com.example.kindergarden.entities.Notification;
import com.example.kindergarden.entities.User;


public interface NotificationService    {
	String addNotification (Long idEvent);
	String addNotificationByDate (Long idUser);
	List<Notification> retrieveNotificationsByParent(Long idParent);
	List<Notification> retrieveAllNotifications();
  boolean verifyTwoDateWithYear(Date startDate, Date endDate);
	
}
