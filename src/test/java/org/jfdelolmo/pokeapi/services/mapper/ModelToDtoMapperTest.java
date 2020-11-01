package org.jfdelolmo.pokeapi.services.mapper;

import org.assertj.core.api.Assertions;
import org.jfdelolmo.pokeapi.dto.PokemonDetailDto;
import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.jfdelolmo.pokeapi.services.MockDataProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ModelToDtoMapperTest {

    @Test
    public void testMapper(){
        //Given
        PokemonModel pokemonModel = MockDataProvider.mockedPokemonModel();

        //When
        PokemonDetailDto dto = ModelToDtoMapper.pokemonModelToPokemonDetailDto(pokemonModel);

        //Then
        assertThat(dto).isNotNull();
        assertThat(dto.getBaseExperience()).isEqualTo(pokemonModel.getBaseExperience());
        assertThat(dto.getDetails()).isEqualTo(pokemonModel.getDetails());
        assertThat(dto.getHeight()).isEqualTo(pokemonModel.getHeight());
        assertThat(dto.getName()).isEqualTo(pokemonModel.getName());
        assertThat(dto.getWeight()).isEqualTo(pokemonModel.getWeight());
    }

}