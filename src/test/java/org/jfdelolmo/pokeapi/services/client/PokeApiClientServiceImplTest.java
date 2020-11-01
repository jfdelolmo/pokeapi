package org.jfdelolmo.pokeapi.services.client;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.model.Generation;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.jfdelolmo.pokeapi.services.MockDataProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jfdelolmo.pokeapi.services.MockDataProvider.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PokeApiClientServiceImplTest {

    private static final PokeApiFactory factory = mock(PokeApiFactory.class);
    private static final PokeApi pokeApi = mock(PokeApi.class);
    private static final Generation MOCKED_GENERATION = MockDataProvider.mockedGeneration();
    private static final Pokemon MOCKED_POKEMON = MockDataProvider.mockedPokemon();

    private final PokeApiClientServiceImpl service = new PokeApiClientServiceImpl(factory);

    @Test
    void retrieveGenerationRedPokemonList() {
        //Given
        when(factory.createInstance()).thenReturn(pokeApi);
        when(pokeApi.getGeneration(anyInt())).thenReturn(MOCKED_GENERATION);
        when(pokeApi.getPokemon(anyInt())).thenReturn(MOCKED_POKEMON);

        //When
        List<Pokemon> result = service.retrieveGenerationRedPokemonList();

        //Then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(MOCKED_ID);
        assertThat(result.get(0).getName()).isEqualTo(MOCKED_NAME);
        assertThat(result.get(0).getBaseExperience()).isEqualTo(MOCKED_BASE_EXPERIENCE);
        assertThat(result.get(0).getHeight()).isEqualTo(MOCKED_HEIGHT);
        assertThat(result.get(0).getWeight()).isEqualTo(MOCKED_WEIGHT);
    }

}