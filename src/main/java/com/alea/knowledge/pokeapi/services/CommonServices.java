package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;

public interface CommonServices {

    CommonWrapper<PokemonInfoDto> getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum);

}
