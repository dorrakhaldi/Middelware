
package com.example.kindergarden.services.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.Notification;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.EventRepository;
import com.example.kindergarden.repositories.NotificationRepository;
import com.example.kindergarden.repositories.UserRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	NotificationRepository Notificationrepository;
	@Autowired
	EventService eventService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	ParentService parentService;
	private static final Logger l = LogManager.getLogger(NotificationServiceImpl.class);
	
	

	@Override
	public String addNotification(Long idEvent) {
		Event event =eventService.retrieveEvent(idEvent);
		// l parents qui appartiennet a cette kinger garten
		List<User>users=userRepository.findByevents(event);
		for(User p:users)
		{
Notification notification = new Notification();
			
			
			notification.setEvents(event);
			notification.setUsers(p);
			notification.setMessage("Demain nous avons un événement ");
			Notification notif=Notificationrepository.save(notification);
			
		}	return "Demain nous avons un événement ";
		}

	@Override
	public List<Notification> retrieveNotificationsByParent(Long idParent) {
		return Notificationrepository.findByUsersId(idParent);
	}
	
	@Override
	public List<Notification> retrieveAllNotifications() {

		List<Notification> Notifications = (List<Notification>) Notificationrepository.findAll();
		for (Notification Notification : Notifications) {
			l.info("Notification" + Notification);
		}
		return Notifications;

	}

	@Override
	public String addNotificationByDate(Long idUser) {
		User u=userRepository.findById(idUser).get();
		List<Event>events=eventRepository.findByUsers(u);
		for(Event e:events)
		{
			if(verifyTwoDateWithYear(e.getDate_event(), new Date())==true)
			{
				Notification notification =new Notification();
				notification.setEvents(e);
				for(User p:e.getUsers())
				{
					
					notification.setUsers(p);
					notification.setMessage("Aujourdhui vous avez un événement ");
					Notification notif=Notificationrepository.save(notification);
					return "Aujourdhui vous avez  un événement ";

				}
				
			}
			
		}
		
		return "Aucun évenement Aujourdhui";
	}

	@Override
	public boolean verifyTwoDateWithYear(Date startDate, Date endDate) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			int year = calendar.get(Calendar.YEAR);
			int mois=calendar.get(Calendar.MONTH);
			int jour=calendar.get(Calendar.DATE);
		    
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(endDate);
			int year2 = calendar2.get(Calendar.YEAR);
			int mois2=calendar2.get(Calendar.MONTH);
			int jour2=calendar2.get(Calendar.DATE);
			
			 if(year == year2 && mois==mois2 && jour==jour2 )
			 {
				 return true;
			 }

else
	    return false;

	}

}



