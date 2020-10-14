package com.alea.knowledge.pokeapi.services;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;

import java.util.List;

public interface PokeApiClientService {

    List<Pokemon> retrieveGenerationRedPokemonList();
}
