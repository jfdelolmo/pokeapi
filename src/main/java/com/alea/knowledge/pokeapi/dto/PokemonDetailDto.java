package com.alea.knowledge.pokeapi.dto;

import lombok.Data;

@Data
public class PokemonDetailDto {

    private String name;

    private int weight;

    private int height;

    private int baseExperience;

    private String details;

}
