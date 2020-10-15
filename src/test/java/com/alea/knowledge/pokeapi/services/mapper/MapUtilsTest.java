package com.alea.knowledge.pokeapi.services.mapper;

import com.alea.knowledge.pokeapi.domain.PokemonModel;
import com.alea.knowledge.pokeapi.services.MockDataProvider;
import com.alea.knowledge.pokeapi.services.mapper.MapUtils;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapUtilsTest {

    @Test
    void pokemonToModel() {
        Pokemon mockedPokemon = MockDataProvider.mockedPokemon();

        PokemonModel model = MapUtils.pokemonToModel(mockedPokemon);

        assertThat(model.getBaseExperience()).isEqualTo(mockedPokemon.getBaseExperience());
        assertThat(model.getDetails()).isEqualTo(MapUtils.ORIGINAL_PREFIX + mockedPokemon.getId());
        assertThat(model.getHeight()).isEqualTo(mockedPokemon.getHeight());
        assertThat(model.getName()).isEqualTo(mockedPokemon.getName());
        assertThat(model.getWeight()).isEqualTo(mockedPokemon.getWeight());
    }

//    @Test
//    void modelToDetailDto() {
//        PokemonModel mockedModel = MockDataProvider.mockedPokemonModel();
//
//        PokemonDetailDto dto = MapperServiceImpl.modelToDetailDto(mockedModel);
//
//        assertThat(dto.getBaseExperience()).isEqualTo(mockedModel.getBaseExperience());
//        assertThat(dto.getDetails()).isEqualTo(mockedModel.getDetails());
//        assertThat(dto.getHeight()).isEqualTo(mockedModel.getHeight());
//        assertThat(dto.getName()).isEqualTo(mockedModel.getName());
//        assertThat(dto.getWeight()).isEqualTo(mockedModel.getWeight());
//    }


}