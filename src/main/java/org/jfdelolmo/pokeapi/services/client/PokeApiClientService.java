package org.jfdelolmo.pokeapi.services.client;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;

import java.util.List;

/**
 * Facade interface for the {@link me.sargunvohra.lib.pokekotlin.client.PokeApi} used to retrieve the information
 * relevant for our use case.
 */
public interface PokeApiClientService {

    /**
     * This method gets the information of the RED generation Pokemons and then ask for it's details.
     *
     * @return Return the list of {@link Pokemon} information-
     */
    List<Pokemon> retrieveGenerationRedPokemonList();

}
