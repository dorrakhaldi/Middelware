package com.example.kindergarden.resetController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kindergarden.entities.Notification;
import com.example.kindergarden.services.services.NotificationService;


@RestController
@CrossOrigin("http://localhost:8080")
public class Notificationcontroller implements java.io.Serializable {

@Autowired
NotificationService CNotification;

//afficher les notifications par parent
//http://localhost:8550/SpringMVC/servlet/retrieve-Notification/{idEvent}
@GetMapping("/retrieve-Notification/{idParent}")
@ResponseBody
public List<Notification> retrieveNotification(@PathVariable("idParent") Long idParent) {
return CNotification.retrieveNotificationsByParent(idParent);
}
@PostMapping("/add-Notification/{iduser}")
@ResponseBody
public String Notification(@PathVariable Long iduser) {
return CNotification.addNotificationByDate(iduser);
} 




}
