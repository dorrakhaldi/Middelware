package com.example.kindergarden.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.kindergarden.entities.Child;
import com.example.kindergarden.entities.Niveau;
import com.example.kindergarden.entities.User;

@Repository
public interface ChildRepository extends JpaRepository <Child,Long> {
  List<Child> findByParent(User id);
  @Query("select c from Child c where c.niveau = ?1")
  List<Child> join (Niveau id);
}