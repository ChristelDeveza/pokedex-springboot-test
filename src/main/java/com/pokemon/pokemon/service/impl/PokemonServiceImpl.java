package com.pokemon.pokemon.service.impl;

import java.util.ArrayList;
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

  @Autowired
  private PokemonRepository pokemonRepository;

 private static List<Pokemon> maListe = new ArrayList<>();

  @Override
  public List<Pokemon> getAllPokemon() {
  //  return maListe;
  return pokemonRepository.findAll();
  }

  @Override
  public Pokemon getPokemonById(Long id) {
    // return maListe.stream()
    //               .filter(pokemon->pokemon.getSurname().equals(name))
    //               .collect(Collectors.toList());
    Optional<Pokemon> pokemOptional = pokemonRepository.findById(id);
      return pokemOptional.orElse(null);
  }

  @Override
  public void updatePokemon(Long id, Pokemon pokemon) {
   this.deletePokemon(id);
  //  maListe.add(pokemon);
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
