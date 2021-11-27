package com.example.kindergarden.services.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kindergarden.entities.Category_Event;
import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.EventRepository;


@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventrepository;
	@Autowired
	EventService eventService;
	@Autowired
	ParentService parentService;
	@Autowired
	NotificationService notifService;
	private static final Logger l = LogManager.getLogger(EventServiceImpl.class);

	@Override
	public List<Event> retrieveAllEvents() {

		List<Event> events = (List<Event>) eventrepository.findAll();
		for (Event event : events) {
			l.info("Event" + event);
		}
		return events;

	}

	@Override
	public Event addEvent(Event e) {
	    eventrepository.save(e);
	   notifService.addNotification(e.getIdEvent());
	return e;
		
	}

	@Override
	public void deleteEvent(Long id) {
		eventrepository.deleteById(id);
	}

	@Override
	public Event updateEvent(Event e ,Long id ) {
		Event event =eventrepository.findById(id).get();
		return eventrepository.save(event);
	}

	@Override
	public Event retrieveEvent(Long id) {
		return eventrepository.findById(id).get();
	}

	@Override
	public Set <User> addParticipation(Long idUser, Long id) {
		Event event =eventrepository.findById(id).get();
		User parent=parentService.retrieveParent(idUser);
		Set<User> listparents=  event.getUsers();
		Set<Event> listpevents=  parent.getEvents();
		listparents.add(parent);
		listpevents.add(event);
		event.setNbr_participants(event.getNbr_participants()+1);
		eventService.updateEvent(event,id);
		return event.getUsers();
	}

	@Override
	public Float getPriceTotale(Long idEvent) {
	Event event =eventService.retrieveEvent(idEvent);
		return (float) (event.getEntry_price()*event.getNbr_participants());
	}


	@Override
	public List<Event> retrieveEventsByCategory(String category) {
		Category_Event ctegorys=null;
		if(Category_Event.Party.toString().equals(category)){
			ctegorys=Category_Event.Party;}
		if(Category_Event.Birthday.toString().equals(category)){
			ctegorys=Category_Event.Birthday;}
		if(Category_Event.Theatre.toString().equals(category)){
			ctegorys=Category_Event.Theatre;}
		if(Category_Event.Sport.toString().equals(category)){
			ctegorys=Category_Event.Sport;}
		if(Category_Event.Competition.toString().equals(category)){
			ctegorys=Category_Event.Competition;}
		if(Category_Event.Dance.toString().equals(category)){
			ctegorys=Category_Event.Dance;}
		return eventrepository.findByCategory(ctegorys);
	}

	@Override
	public List<User> addInterested(long idUser, long id) {
		Event event =eventService.retrieveEvent(id);
		User parent=parentService.retrieveParent(idUser);
		List<User>listParent=new ArrayList<>();
		listParent.add(parent);
		event.setNbr_interssants(event.getNbr_interssants()+1);
		return listParent;
	}

	

}