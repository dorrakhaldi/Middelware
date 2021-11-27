package com.example.kindergarden.services.services;

import java.util.List;
import java.util.Set;

import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.User;


public interface EventService    {
	List<Event> retrieveAllEvents();
	List<Event> retrieveEventsByCategory(String category);
	Event addEvent (Event e);
	void deleteEvent(Long id);
	Event updateEvent(Event e, Long id);
    Event retrieveEvent(Long id);
    Set<User> addParticipation (Long idUser, Long id);
	Float getPriceTotale(Long idEvent);
	public List<User> addInterested(long idUser, long id);

}
