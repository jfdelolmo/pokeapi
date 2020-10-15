package com.alea.knowledge.pokeapi.services.mapper;

import com.alea.knowledge.pokeapi.dto.PokemonDetailDto;
import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.model.PokemonModel;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUtils {

    public static final String ORIGINAL_PREFIX = "https://pokeapi.co/api/v2/pokemon/";

    private static final Map<FilterCriteriaEnum, String> filterCriteriaMap = Collections.unmodifiableMap(
            Stream.of(
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.BASE_EXPERIENCE, "baseExperience"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HEAVY, "weight"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HIGH, "height")
            ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
    );

    /**
     * Responsible of mapping the relevant {@link Pokemon} data used in the {@link PokemonModel}
     *
     * @param pokemon The source object
     * @return A new mapped PokemonModel object
     */
    public static PokemonModel pokemonToModel(Pokemon pokemon) {
        PokemonModel model = new PokemonModel();
        model.setBaseExperience(pokemon.getBaseExperience());
        model.setName(pokemon.getName());
        model.setWeight(pokemon.getWeight());
        model.setHeight(pokemon.getHeight());
        model.setDetails(ORIGINAL_PREFIX + pokemon.getId());
        return model;
    }

    /**
     * Responsible of mapping the properties from {@link PokemonModel} to a {@link PokemonDetailDto}
     *
     * @param pokemonModel The source object
     * @return A new mapped PokemonDetailDto object
     */
    public static PokemonDetailDto modelToDetailDto(PokemonModel pokemonModel) {
        PokemonDetailDto dto = new PokemonDetailDto();
        dto.setBaseExperience(pokemonModel.getBaseExperience());
        dto.setName(pokemonModel.getName());
        dto.setWeight(pokemonModel.getWeight());
        dto.setHeight(pokemonModel.getHeight());
        dto.setDetails(pokemonModel.getDetails());
        return dto;
    }

    /**
     * Responsible of mapping the filterCriteriaEnum to the name of the top sorting column
     *
     * @param filterCriteriaEnum The FilterCriteriaEnum value
     * @return The name of the top sorting column
     */
    public static String getTopCriteria(FilterCriteriaEnum filterCriteriaEnum) {
        return filterCriteriaMap.get(filterCriteriaEnum);
    }


}
