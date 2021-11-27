package com.example.kindergarden.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Data
@NoArgsConstructor
@Entity
@Table(name = "EVENT")
@CrossOrigin("http://localhost:8080")
public class Event  {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Event_id")
  private Long idEvent;

  @Column(name = "Event_title")
  private String title;
  @Lob
  @Column(name = "Event_Photo")
  private byte[]  photo;

  @Column(name = "Event_Description")
  private String description;

  @Temporal(TemporalType.DATE)
  @Column(name = "Event_Date")
  private Date date_event;
  @Temporal(TemporalType.DATE)
  @Column(name = "Event_start_heure")
  private java.util.Date event_start_heure;
  @Temporal(TemporalType.DATE)
  @Column(name = "Event_fin_heure")
  private java.util.Date event_fin_heure;

  @Temporal(TemporalType.DATE)
  @Column(name = "Event_Final_reservation")
  private Date date_final_reservation;

  @Column(name = "Event_Nbr_Place")
  private int nbr_places;

  @Column(name = "Event_Nbr_Participants")
  private int nbr_participants;

  @Column(name = "Event_Nbr_interessants")
  private int nbr_interssants;

  @Column(name = "Event_Nbr_places_occupes")
  private int nbr_places_occupes;

  @Column(name = "Event_Nbr_ignorer")
  private int Nbr_ignorer;

  @Column(name = "Event_invites")
  private int nbr_invites;

  @Column(name = "Event_budget")
  private Double event_budget;

  @Column(name = "Entry_price")
  private Double entry_price;
  @JsonIgnore
  @Transient
  @OneToMany(cascade = CascadeType.ALL, mappedBy="events",fetch=FetchType.LAZY)
  public Set<Notification> notifications;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "event_userss",
      joinColumns = @JoinColumn(name = "event_id"),
      inverseJoinColumns = @JoinColumn(name = "parent_id"))
  public Set<User>users;


  @Enumerated(EnumType.STRING)
  private Category_Event category;

  @Enumerated(EnumType.STRING)
  private Etat_event etat_event;

  @Enumerated(EnumType.STRING)
  private Type_Event type_event;

  @Enumerated(EnumType.STRING)
  private locationevent location_event;




}
