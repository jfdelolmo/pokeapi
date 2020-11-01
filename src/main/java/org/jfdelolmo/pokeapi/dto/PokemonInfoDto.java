package org.jfdelolmo.pokeapi.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PokemonInfoDto {

    private List<PokemonDetailDto> pokemons = new ArrayList<>();

}
