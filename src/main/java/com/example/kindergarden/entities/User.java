package com.example.kindergarden.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="User")
@CrossOrigin("http://localhost:8080")
public class User {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  private String Email;
  private String adresse;
  private int tel;
  private Date dateNaissance;
  private String Password;
  @Enumerated(EnumType.STRING)
  private Role role;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy="users",fetch= FetchType.LAZY)
  public Set<Notification> notifications;

  @OneToMany(cascade = CascadeType.ALL, mappedBy="parent",fetch= FetchType.LAZY)
  public Set<Child> children=new HashSet<>();
  @ManyToMany(mappedBy = "users")
  Set <Event> events;
  @ManyToOne
  Niveau niveau;



}
