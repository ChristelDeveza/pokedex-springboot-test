package com.pokemon.pokemon.service;

import java.util.List;

import com.pokemon.pokemon.pojo.Pokemon;

public interface PokemonService {
  List<Pokemon> getAllPokemon();
  List<Pokemon> getAllPokemonByName(String name);

  void updatePokemon(String pokemonName, Pokemon pokemon);
  void createPokemon(Pokemon pokemon);
  void deletePokemon(String name);
}
