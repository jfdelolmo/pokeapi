package com.alea.knowledge.pokeapi.services;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Generation;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokeApiClientServiceImpl implements PokeApiClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokeApiClientServiceImpl.class);

    private static final int RED_GENERATION_ID = 1;

    private final PokeApi pokeApi = new PokeApiClient();

    /**
     * Use the PokeApi client to get the species information from the red generation and then asks
     * for the detailed information of each pokemon.
     *
     * @return the list of Pokemon
     * @see PokeApi
     */
    public List<Pokemon> retrieveGenerationRedPokemonList() {
        List<Pokemon> toReturn = getRedGeneration().getPokemonSpecies()
                .parallelStream()
                .map(NamedApiResource::getId)
                .map(this::getPokemonById)
                .collect(Collectors.toList());
        LOGGER.debug("Items retrieved from pokeApi service: " + toReturn.size());
        return toReturn;
    }

    private Generation getRedGeneration() {
        return pokeApi.getGeneration(RED_GENERATION_ID);
    }

    private Pokemon getPokemonById(int id) {
        return pokeApi.getPokemon(id);
    }
}
