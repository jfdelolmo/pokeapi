package com.alea.knowledge.pokeapi.services.loader;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.alea.knowledge.pokeapi.repository.PokeRepository;
import com.alea.knowledge.pokeapi.services.client.PokeApiClientService;
import com.alea.knowledge.pokeapi.services.client.PokeApiClientServiceImpl;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class PokemonDataLoaderImplTest {

  public PokeRepository repository = mock(PokeRepository.class);
  public PokeApiClientService pokeApiClientService = mock(PokeApiClientServiceImpl.class);

  private PokemonDataLoader loader = new PokemonDataLoaderImpl(repository, pokeApiClientService);

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void initializeDataBase() {
    when(pokeApiClientService.retrieveGenerationRedPokemonList()).thenReturn(new ArrayList<>());
    when(repository.saveAll(any())).thenReturn(new ArrayList<>());

    loader.initializeDataBase();

    verify(pokeApiClientService, times(1)).retrieveGenerationRedPokemonList();
    verify(repository, times(1)).saveAll(any());
  }

}