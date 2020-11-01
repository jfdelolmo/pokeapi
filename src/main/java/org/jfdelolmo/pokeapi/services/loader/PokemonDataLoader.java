package org.jfdelolmo.pokeapi.services.loader;

public interface PokemonDataLoader {

    /**
     * Method responsible of filling the information of the database for caching the data.
     */
    void initializeDataBase();

}
