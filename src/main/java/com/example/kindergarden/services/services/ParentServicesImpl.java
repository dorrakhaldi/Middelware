package com.example.kindergarden.services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kindergarden.entities.User;
import com.example.kindergarden.repositories.UserRepository;


@Service
public class ParentServicesImpl implements ParentService {
@Autowired
private UserRepository parentRepository;

@Override
public User retrieveParent(Long id) {
	return parentRepository.findById(id).get();
}
	}
	
	