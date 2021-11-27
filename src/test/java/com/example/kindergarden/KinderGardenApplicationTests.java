package com.example.kindergarden;

import static com.example.kindergarden.entities.Category_Event.Party;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kindergarden.entities.Child;
import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.Notification;
import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.ChildRepository;
import com.example.kindergarden.repositories.UserRepository;
import com.example.kindergarden.services.services.EventService;
import com.example.kindergarden.services.services.UploadImageService;

@SpringBootTest
class KinderGardenApplicationTests {
  @Autowired
  EventService CEvent;
  @Autowired
  UploadImageService uploadImageService;
  @Autowired
  ChildRepository Childrepository;
  @Autowired
  UserRepository Parentrepository;
  @Test
  void addParent() {
    Date d =new Date (11/12/1999);
    Child cc= Childrepository.findById(1L).get();
    List<Child> c=new ArrayList<>();
    List<Notification> not=new ArrayList<>();
    c.add(cc);
    User p=new User();
    p.setLastName("saleh");
    Parentrepository.save(p);
  }
  @Test
  void addChild() {
    Date d =new Date (11/12/1999);
    User cc= Parentrepository.findById(5L).get();
    Child p=new Child();
    p.setLastName("saleh");
    p.setDateNaissance(d);
    p.setParent(cc);
    Childrepository.save(p);
  }

  @Test
  void addEvent() {
    Event e=new Event();
    e.setNbr_interssants(20);
    e.setCategory(Party);
     CEvent.addEvent(e);
  }
}
