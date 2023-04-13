package com.pokemon.pokemon.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Pokedex {
  
  @Id
  @SequenceGenerator(name = "pokedex_seq", sequenceName = "pokedex_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokedex_seq")
  @Column(name = "pokedex_id", updatable = false)
  private Long id;

  @Column(name = "region")
  private String region;

  @OneToMany(mappedBy = "pokedex")
  private List<Pokemon> pokemonList;

  public Pokedex(String region, List<Pokemon> pokemonList) {
    this.region = region;
    this.pokemonList = pokemonList;
  }
  
  public Pokedex(Long id, String region, List<Pokemon> pokemonList) {
    this.id = id;
    this.region = region;
    this.pokemonList = pokemonList;
 
  }

  public Pokedex() {
    //Needed Hibernate
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public List<Pokemon> getPokemonList() {
    return pokemonList;
  }

  public void setPokemonList(List<Pokemon> pokemonList) {
    this.pokemonList = pokemonList;
  }

}
