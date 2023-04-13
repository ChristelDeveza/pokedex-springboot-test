package com.pokemon.pokemon.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Capacite {

  @Id
  @SequenceGenerator(name = "capacite_seq", sequenceName = "capacite_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capacite_seq")
  @Column(name = "capacite_id", updatable = false)
  private Long id;
  
  private String libelle;
  
  private Long puissance;

  @ManyToOne
  @JoinColumn(name = "pokemon_id", nullable = false)
  private Pokemon pokemon;

  public Capacite(String libelle, Long puissance) {
    this.libelle = libelle;
    this.puissance = puissance;
  }

  public Capacite(Long id, String libelle, Long puissance) {
    this.id = id;
    this.libelle = libelle;
    this.puissance = puissance;
  }

  public Capacite() {
    //Needed Hibernate
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public Long getPuissance() {
    return puissance;
  }

  public void setPuissance(Long puissance) {
    this.puissance = puissance;
  }

}
