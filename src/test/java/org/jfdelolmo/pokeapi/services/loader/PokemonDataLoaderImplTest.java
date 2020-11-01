package org.jfdelolmo.pokeapi.services.loader;

import org.jfdelolmo.pokeapi.repository.PokeRepository;
import org.jfdelolmo.pokeapi.services.client.PokeApiClientService;
import org.jfdelolmo.pokeapi.services.client.PokeApiClientServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PokemonDataLoaderImplTest {

    public static final PokeRepository repository = mock(PokeRepository.class);
    public static final PokeApiClientService pokeApiClientService = mock(PokeApiClientServiceImpl.class);

    private final PokemonDataLoader loader = new PokemonDataLoaderImpl(repository, pokeApiClientService);

    @Test
    public void initializeDataBase() {
        //Given
        when(pokeApiClientService.retrieveGenerationRedPokemonList()).thenReturn(new ArrayList<>());
        when(repository.saveAll(any())).thenReturn(new ArrayList<>());

        //When
        loader.initializeDataBase();

        //Then
        verify(pokeApiClientService, times(1)).retrieveGenerationRedPokemonList();
        verify(repository, times(1)).saveAll(any());
    }

}