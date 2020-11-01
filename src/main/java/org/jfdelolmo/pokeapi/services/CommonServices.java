package org.jfdelolmo.pokeapi.services;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.jfdelolmo.pokeapi.model.FilterCriteriaEnum;

public interface CommonServices {

    /**
     * Parameterized generic method to retrieve top information based in the {@link FilterCriteriaEnum} value.
     *
     * @param top                Number of elements conforming the top
     * @param filterCriteriaEnum The desired field conforming the top
     * @return The wrapped information conforming the top
     */
    PokemonInfoDto getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum) throws PokemonException;

}
