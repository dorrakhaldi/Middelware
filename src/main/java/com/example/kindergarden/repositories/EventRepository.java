package com.example.kindergarden.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kindergarden.entities.Category_Event;
import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.User;


@Repository
public interface EventRepository extends  JpaRepository<Event,Long>{
  List<Event> findByCategory(Category_Event ctegory);
  List<Event> findByUsers(User idUser);
}
