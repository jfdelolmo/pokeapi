package com.alea.knowledge.pokeapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonInfoDto {

    String error;

    List<? extends PokemonDetailDto> pokemons;

}
