package com.example.kindergarden.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name="Niveau")
@CrossOrigin("http://localhost:8080")
public class Niveau {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String label;
  @OneToMany(cascade = CascadeType.ALL, mappedBy="niveau",fetch= FetchType.LAZY)
  private Set<Child> children;
  @OneToMany(cascade = CascadeType.ALL, mappedBy="niveau",fetch= FetchType.LAZY)
  private Set<User> teachers;
}
