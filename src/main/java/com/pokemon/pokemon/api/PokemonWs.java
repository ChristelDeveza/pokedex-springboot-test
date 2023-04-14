package com.pokemon.pokemon.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

import com.pokemon.pokemon.pojo.Pokemon;
import com.pokemon.pokemon.service.PokemonService;

//restcontroller ne permet pas de renvoyer du HTML
@Controller
@RequestMapping(value=ApiRegistration.REST_PREFIX + ApiRegistration.REST_POKEMON)
public class PokemonWs {
  
  @Autowired
  private PokemonService service;

  @GetMapping
  public ModelAndView getAllPokemon() {
    ModelAndView modelAndView = new ModelAndView();
    //TODO
    modelAndView.setViewName("index.html");
    modelAndView.addObject("test", "test success");
    return modelAndView;
    // return service.getAllPokemon();
  }

  @GetMapping("{id}")
  public Pokemon getPokemonById(@PathVariable(name = "id") Long id) {
    return service.getPokemonById(id);
  }

  @PostMapping
  public void createPokemon(@RequestBody Pokemon pokemon) {
    service.createPokemon(pokemon);
  }

  @PutMapping("{id}")
  public void updatePokemon(@PathVariable(name = "id") Long id, @RequestBody Pokemon pokemon) {
service.updatePokemon(id, pokemon);
  }

  @DeleteMapping("{id}")
  public void deletePokemon(@PathVariable(name = "id") Long id) {
    service.deletePokemon(id);
  }
}
