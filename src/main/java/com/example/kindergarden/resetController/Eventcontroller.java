package com.example.kindergarden.resetController;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.services.services.EventService;
import com.example.kindergarden.services.services.UploadImageService;

@RestController
@CrossOrigin("http://localhost:8080")
public class Eventcontroller implements java.io.Serializable{

@Autowired
EventService CEvent;
@Autowired
UploadImageService uploadImageService;

@PostMapping("/add-event")
@ResponseBody
public Event addEvent(@RequestBody Event event) throws IOException {

	/*System.out.println("Original Image Byte Size - " + file.getBytes().length);

	//event.setPhoto(uploadImageService.compressBytes(file.getBytes()));*/
	return CEvent.addEvent(event);
}
@GetMapping("/retriveallevent")
@ResponseBody
public List<Event> getEvent() {
	List<Event> list= CEvent.retrieveAllEvents();
	return list;}
@PutMapping("/update-event/{event-id}")
@ResponseBody
public Event ModifierEvent(@PathVariable(name="event-id") Long id ,@RequestBody Event event) throws IOException{
	/*System.out.println("Original Image Byte Size - " + file.getBytes().length);
	event.setPhoto(uploadImageService.compressBytes(file.getBytes()));*/
	return CEvent.updateEvent(event,id);
} 

@DeleteMapping("/remove-event/{event-id}")
@ResponseBody
public void removeEvent(@PathVariable(name="event-id")
Long idEvent) {
	CEvent.deleteEvent(idEvent);
}


@GetMapping("/retrieve-event/{idEvent}")
@ResponseBody
public Event retrieveEvent(@PathVariable("idEvent") Long idEvent) {
return CEvent.retrieveEvent(idEvent);
} 



@PostMapping("/add-participant/{idParent}/event/{idEvent}")
@ResponseBody
public Collection<User> addParticipant(@PathVariable Long idParent, @PathVariable Long idEvent) {
return CEvent.addParticipation(idParent, idEvent);
}

@GetMapping("/retrieve-Price/{idEvent}")
@ResponseBody
public Float retrievePrice(@PathVariable("idEvent") Long idEvent) {
return CEvent.getPriceTotale(idEvent);
} 

@GetMapping("/retrieve-Event-ByCategory/{category}/")
@ResponseBody
public List<Event> retrieveEventByCategory(@PathVariable String category) {

return CEvent.retrieveEventsByCategory(category);
} 


@PostMapping("/add-Interested/{idParent}/event/{idEvent}")
@ResponseBody
public List<User> addInterested(@PathVariable Long idParent, @PathVariable Long idEvent) {
return CEvent.addInterested(idParent, idEvent);
}

}

