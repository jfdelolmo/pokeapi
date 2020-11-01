package org.jfdelolmo.pokeapi.services.mapper;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.jfdelolmo.pokeapi.model.PokemonModel;

public class ClientModelToModel {

    public static final String ORIGINAL_PREFIX = "https://pokeapi.co/api/v2/pokemon/";

    /**
     * Responsible of mapping the relevant {@link Pokemon} data used in the {@link PokemonModel}
     *
     * @param pokemon The source object
     * @return A new mapped PokemonModel object
     */
    public static PokemonModel clientPokemonToPokemonModel(Pokemon pokemon) {
        PokemonModel model = new PokemonModel();
        model.setBaseExperience(pokemon.getBaseExperience());
        model.setName(pokemon.getName());
        model.setWeight(pokemon.getWeight());
        model.setHeight(pokemon.getHeight());
        model.setDetails(ORIGINAL_PREFIX + pokemon.getId());
        return model;
    }
}
