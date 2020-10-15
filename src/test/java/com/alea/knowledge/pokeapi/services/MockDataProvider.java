package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonDetailDto;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.model.PokemonModel;
import com.alea.knowledge.pokeapi.services.mapper.MapUtils;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class MockDataProvider {

    public static final Long MOCKED_INTERNAL_ID = 1L;

    public static final Integer MOCKED_ID = 1;
    public static final Integer MOCKED_BASE_EXPERIENCE = 2;
    public static final Integer MOCKED_HEIGHT = 3;
    public static final String MOCKED_NAME = "Pikachu";
    public static final Integer MOCKED_WEIGHT = 4;
    public static final NamedApiResource MOCKED_SPECIES = initMockedSpecies();
    public static final PokemonSprites MOCKED_SPRITES = initMockedSprites();

    public static PokemonModel mockedPokemonModel() {
        PokemonModel model = new PokemonModel();
        model.setBaseExperience(MOCKED_BASE_EXPERIENCE);
        model.setDetails(MapUtils.ORIGINAL_PREFIX + MOCKED_ID);
        model.setHeight(MOCKED_HEIGHT);
        model.setId(MOCKED_INTERNAL_ID);
        model.setName(MOCKED_NAME);
        model.setWeight(MOCKED_WEIGHT);
        return model;

    }

    public static Pokemon mockedPokemon() {
        return new Pokemon(
                MOCKED_ID,
                MOCKED_NAME,
                MOCKED_BASE_EXPERIENCE,
                MOCKED_HEIGHT,
                true,
                0,
                MOCKED_WEIGHT,
                MOCKED_SPECIES,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                MOCKED_SPRITES);
    }

    private static NamedApiResource initMockedSpecies() {
        return new NamedApiResource("MOCKED_NAME", "MOCKED_CATEGORY", 0);
    }

    private static PokemonSprites initMockedSprites() {
        return new PokemonSprites(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    public static CommonWrapper<PokemonInfoDto> initMockedWrapper(HttpStatus httpStatus) {
        CommonWrapper<PokemonInfoDto> mockedWrapper = new CommonWrapper<>();
        mockedWrapper.setHttpStatus(httpStatus);
        mockedWrapper.setDto(mockedPokemonInfo(!HttpStatus.OK.equals(httpStatus)));
        return mockedWrapper;
    }

    private static PokemonInfoDto mockedPokemonInfo(boolean hasError) {
        PokemonInfoDto mockedWrapper = new PokemonInfoDto();
        mockedWrapper.setError(hasError ? "This is a mocked error" : null);
        mockedWrapper.setPokemons(new ArrayList<>());
        mockedWrapper.getPokemons().add(mockedPokemonDetailDto());
        return mockedWrapper;
    }

    private static PokemonDetailDto mockedPokemonDetailDto() {
        PokemonDetailDto mockedPokemonDetailDto = new PokemonDetailDto();
        mockedPokemonDetailDto.setWeight(1);
        mockedPokemonDetailDto.setName("Pikachu");
        mockedPokemonDetailDto.setHeight(2);
        mockedPokemonDetailDto.setBaseExperience(3);
        mockedPokemonDetailDto.setDetails("Mocked_details_url");
        return mockedPokemonDetailDto;
    }

}
