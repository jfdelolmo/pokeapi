package org.jfdelolmo.pokeapi.services.mapper;

import org.jfdelolmo.pokeapi.dto.PokemonDetailDto;
import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.model.PokemonModel;

import java.util.List;
import java.util.stream.Collectors;

public class ModelToDtoMapper {

    /**
     * Responsible of mapping the properties from {@link PokemonModel} to a {@link PokemonDetailDto}
     *
     * @param pokemonModel The source object
     * @return A new mapped PokemonDetailDto object
     */
    public static PokemonDetailDto pokemonModelToPokemonDetailDto(PokemonModel pokemonModel) {
        PokemonDetailDto dto = new PokemonDetailDto();
        dto.setBaseExperience(pokemonModel.getBaseExperience());
        dto.setName(pokemonModel.getName());
        dto.setWeight(pokemonModel.getWeight());
        dto.setHeight(pokemonModel.getHeight());
        dto.setDetails(pokemonModel.getDetails());
        return dto;
    }

}
