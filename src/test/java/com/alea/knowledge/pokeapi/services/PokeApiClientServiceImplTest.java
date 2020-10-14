package com.alea.knowledge.pokeapi.services;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
class PokeApiClientServiceImplTest {

    PokeApiClientServiceImpl service = new PokeApiClientServiceImpl();

    @Test
    void retrieveGenerationRedPokemonList() {
        List<Pokemon> result = service.retrieveGenerationRedPokemonList();

        assertThat(result.size()).isEqualTo(151);
    }

}