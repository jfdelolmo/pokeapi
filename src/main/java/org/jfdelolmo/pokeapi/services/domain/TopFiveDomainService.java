package org.jfdelolmo.pokeapi.services.domain;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokemonException;

/**
 * Service handling the top five requests
 */
public interface TopFiveDomainService {

    PokemonInfoDto topFiveHeaviest() throws PokemonException;

    PokemonInfoDto topFiveHighest() throws PokemonException;

    PokemonInfoDto topFiveBaseExperienced() throws PokemonException;
}
