package org.jfdelolmo.pokeapi.services.mapper;

import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.jfdelolmo.pokeapi.services.MockDataProvider;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientModelToModelTest {

    @Test
    void pokemonToModel() {
        //Given
        Pokemon mockedPokemon = MockDataProvider.mockedPokemon();

        //When
        PokemonModel model = ClientModelToModel.clientPokemonToPokemonModel(mockedPokemon);

        //Then
        assertThat(model.getBaseExperience()).isEqualTo(mockedPokemon.getBaseExperience());
        assertThat(model.getDetails()).isEqualTo(ClientModelToModel.ORIGINAL_PREFIX + mockedPokemon.getId());
        assertThat(model.getHeight()).isEqualTo(mockedPokemon.getHeight());
        assertThat(model.getName()).isEqualTo(mockedPokemon.getName());
        assertThat(model.getWeight()).isEqualTo(mockedPokemon.getWeight());
    }

}