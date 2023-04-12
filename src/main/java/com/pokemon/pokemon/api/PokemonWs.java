package com.pokemon.pokemon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokemon.pojo.Pokemon;
import com.pokemon.pokemon.service.PokemonService;

@RestController
@RequestMapping(value=ApiRegistration.REST_PREFIX + ApiRegistration.REST_POKEMON)
public class PokemonWs {
  
  @Autowired
  private PokemonService service;
  @GetMapping
  public List<Pokemon> getAllPokemon() {
    return service.getAllPokemon();
  }

  @GetMapping("{name}")
  public List<Pokemon> getAllPokemonByName(@PathVariable(name = "name") String nom) {
    return service.getAllPokemonByName(nom);
  }

  @PostMapping
  public void createPokemon(@RequestBody Pokemon pokemon) {
    service.createPokemon(pokemon);
  }

  @PutMapping("{name}")
  public void updatePokemon(@PathVariable(name = "name") String nom, @RequestBody Pokemon pokemon) {
service.updatePokemon(nom, pokemon);
  }

  @DeleteMapping("{name}")
  public void deletePokemon(@PathVariable(name = "name") String nom) {
    service.deletePokemon(nom);
  }
}
