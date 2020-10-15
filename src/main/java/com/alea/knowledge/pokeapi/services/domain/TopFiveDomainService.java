package com.alea.knowledge.pokeapi.services.domain;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;

/**
 * Service handling the top five requests
 */
public interface TopFiveDomainService {

    CommonWrapper<PokemonInfoDto> topFiveHeaviest();

    CommonWrapper<PokemonInfoDto> topFiveHighest();

    CommonWrapper<PokemonInfoDto> topFiveBaseExperienced();
}
