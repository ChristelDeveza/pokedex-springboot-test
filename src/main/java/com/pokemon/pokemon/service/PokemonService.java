package com.pokemon.pokemon.service;

import java.util.List;

import com.pokemon.pokemon.pojo.Pokemon;

public interface PokemonService {
  List<Pokemon> getAllPokemon();
  Pokemon getPokemonById(Long id);

  void updatePokemon(Long id, Pokemon pokemon);
  void createPokemon(Pokemon pokemon);
  void deletePokemon(Long id);
}
