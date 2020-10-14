package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;

public interface TopFiveDomainService {

    //The 5 heaviest Pokémons.
    CommonWrapper<PokemonInfoDto> topFiveHeaviest() throws Exception;

    //The 5 highest Pokémons.
    CommonWrapper<PokemonInfoDto> topFiveHighest() throws Exception;

    //The 5 Pokémons with more base experience.
    CommonWrapper<PokemonInfoDto> topFiveBaseExperienced() throws Exception;
}
