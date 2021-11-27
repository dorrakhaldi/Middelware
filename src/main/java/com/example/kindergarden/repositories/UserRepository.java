package com.example.kindergarden.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kindergarden.entities.Event;
import com.example.kindergarden.entities.Role;
import com.example.kindergarden.entities.User;


@Repository
public interface UserRepository extends  JpaRepository<User,Long>{
	 List<User> findByRole(Role role);
	List<User> findByevents(Event event);
}
