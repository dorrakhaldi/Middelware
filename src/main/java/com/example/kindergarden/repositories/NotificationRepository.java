package com.example.kindergarden.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kindergarden.entities.Notification;

@Repository
public interface NotificationRepository extends  JpaRepository<Notification,Long>{
	List<Notification> findByUsersId(Long id);
}
