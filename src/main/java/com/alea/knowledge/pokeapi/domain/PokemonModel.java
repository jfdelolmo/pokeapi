package com.alea.knowledge.pokeapi.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PokemonModel {

    @Id
    @GeneratedValue
    private Long id;

    String name;

    private int weight;
    private int height;
    private int baseExperience;

    private String details;
}
