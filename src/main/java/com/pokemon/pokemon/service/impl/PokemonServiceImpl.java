package com.pokemon.pokemon.service.impl;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokemon.pojo.Pokemon;
import com.pokemon.pokemon.repository.PokemonRepository;
import com.pokemon.pokemon.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

  // private static List<Pokemon> maListe = new ArrayList<>();

  @Autowired
  private PokemonRepository pokemonRepository;

  @Override
  public List<Pokemon> getAllPokemon() {
  //  
  return pokemonRepository.findAll();
  }

  @Override
  public Pokemon getPokemonById(Long id) {
    // return maListe.stream()
    //               .filter(pokemon->pokemon.getSurname().equals(name))
    //               .collect(Collectors.toList());
    Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id); // peut ne contenir aucun élément peut être vide
    if(pokemonOptional.isPresent()) {
      return pokemonOptional.get();
    } else {
      return null;
    }

    // return pokemonOptional.orElse(null)
    
    
  }

  @Override
  public void updatePokemon(Long id, Pokemon pokemon) {
  //  this.deletePokemon(pokemonName);
  //  maListe.add(pokemon);
  this.deletePokemon(id);
  pokemonRepository.save(pokemon);
  }

  @Override
  public void createPokemon(Pokemon pokemon) {
  //  maListe.add(pokemon);
  pokemonRepository.save(pokemon);
  }

  @Override
  public void deletePokemon(Long id) {
    // maListe.removeIf(monPokemon -> monPokemon.getSurname().equals(name));
    pokemonRepository.deleteById(id);
  }
  
}
