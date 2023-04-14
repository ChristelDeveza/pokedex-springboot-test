package com.pokemon.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.pokemon.pojo.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
  
}
