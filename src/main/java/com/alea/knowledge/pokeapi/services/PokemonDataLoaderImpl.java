package com.alea.knowledge.pokeapi.services;


import com.alea.knowledge.pokeapi.domain.PokemonModel;
import com.alea.knowledge.pokeapi.repository.PokeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PokemonDataLoaderImpl implements PokemonDataLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonDataLoaderImpl.class);

    private final PokeRepository repository;
    private final PokeApiClientService pokeApiClientService;

    public void initializeDataBase() {
        List<PokemonModel> saved = repository.saveAll(getListOfPokemonModel());
        LOGGER.debug("Items saved in the database: " + saved.size());
    }

    private List<PokemonModel> getListOfPokemonModel() {
        return pokeApiClientService.retrieveGenerationRedPokemonList()
                .parallelStream()
                .map(MapperServiceImpl::pokemonToModel)
                .collect(Collectors.toList());
    }

}
