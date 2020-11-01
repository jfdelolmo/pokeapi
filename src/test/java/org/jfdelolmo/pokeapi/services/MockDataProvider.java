package org.jfdelolmo.pokeapi.services;

import me.sargunvohra.lib.pokekotlin.model.Generation;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import org.jfdelolmo.pokeapi.dto.PokemonDetailDto;
import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.jfdelolmo.pokeapi.services.mapper.ClientModelToModel;

import java.util.ArrayList;
import java.util.List;

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
        model.setDetails(ClientModelToModel.ORIGINAL_PREFIX + MOCKED_ID);
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

    public static PokemonInfoDto mockedPokemonInfo() {
        PokemonInfoDto mockedPokemonInfoDto = new PokemonInfoDto();
        mockedPokemonInfoDto.setPokemons(new ArrayList<>());
        mockedPokemonInfoDto.getPokemons().add(mockedPokemonDetailDto());
        return mockedPokemonInfoDto;
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

    public static Generation mockedGeneration() {
        List<NamedApiResource> mokedPokemonSpecies = new ArrayList<>();
        mokedPokemonSpecies.add(new NamedApiResource("MOCKED_SPECIES", "MOCKED_CATEGORY", 1));
        return new Generation(
                1, //val id: Int,
                "mockedGeneration", //val name: String,
                new ArrayList<>(), //val abilities: List<NamedApiResource>,
                new ArrayList<>(), //val names: List<Name>,
                new NamedApiResource(
                        "mainRegion", //oval name: String,
                        "category", //override val category: String,
                        1 //override val id: Int
                ), //val mainRegion: NamedApiResource,
                new ArrayList<>(), //val moves: List<NamedApiResource>,
                mokedPokemonSpecies, //val pokemonSpecies: List<NamedApiResource>,
                new ArrayList<>(), //val types: List<NamedApiResource>,
                new ArrayList<>() //val versionGroups: List<NamedApiResource>
        );
    }

}
