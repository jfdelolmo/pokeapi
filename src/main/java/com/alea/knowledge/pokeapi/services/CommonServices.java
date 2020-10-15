package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;

public interface CommonServices {

    /**
     * Parameterized generic method to retrieve top information based in the {@link FilterCriteriaEnum} value.
     * The {@link PokemonInfoDto} information is wrapped inside {@link CommonWrapper} used to handle the http status code.
     * @param top                   Number of elements conforming the top
     * @param filterCriteriaEnum    The desired field conforming the top
     * @return The wrapped information conforming the top
     */
    CommonWrapper<PokemonInfoDto> getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum);

}
