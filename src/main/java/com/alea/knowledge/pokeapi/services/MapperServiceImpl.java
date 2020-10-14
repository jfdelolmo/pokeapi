package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.domain.PokemonModel;
import com.alea.knowledge.pokeapi.dto.PokemonDetailDto;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public class MapperServiceImpl {

    protected static final String ORIGINAL_PREFIX = "https://pokeapi.co/api/v2/pokemon/";

    public static PokemonModel pokemonToModel(Pokemon pokemon) {
        PokemonModel model = new PokemonModel();
        model.setBaseExperience(pokemon.getBaseExperience());
        model.setName(pokemon.getName());
        model.setWeight(pokemon.getWeight());
        model.setHeight(pokemon.getHeight());
        model.setDetails(ORIGINAL_PREFIX + pokemon.getId());
        return model;
    }

    public static PokemonDetailDto modelToDetailDto(PokemonModel model) {
        PokemonDetailDto dto = new PokemonDetailDto();
        dto.setBaseExperience(model.getBaseExperience());
        dto.setName(model.getName());
        dto.setWeight(model.getWeight());
        dto.setHeight(model.getHeight());
        dto.setDetails(model.getDetails());
        return dto;
    }

}
