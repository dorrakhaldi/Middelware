package com.example.kindergarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kindergarden.entities.Niveau;
@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Long> {

}
