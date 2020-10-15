package com.alea.knowledge.pokeapi.services.loader;

import com.alea.knowledge.pokeapi.model.PokemonModel;
import com.alea.knowledge.pokeapi.repository.PokeRepository;
import com.alea.knowledge.pokeapi.services.client.PokeApiClientService;
import com.alea.knowledge.pokeapi.services.mapper.MapUtils;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

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
        .map(MapUtils::pokemonToModel)
        .collect(Collectors.toList());
  }

}
