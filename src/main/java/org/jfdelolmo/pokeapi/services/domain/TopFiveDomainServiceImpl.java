package org.jfdelolmo.pokeapi.services.domain;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.jfdelolmo.pokeapi.model.FilterCriteriaEnum;
import org.jfdelolmo.pokeapi.services.CommonServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopFiveDomainServiceImpl implements TopFiveDomainService {

    /**
     * Used to indicate the number of items conforming the top
     */
    private static final int TOP = 5;

    private final CommonServices commonServices;

    @Override
    public PokemonInfoDto topFiveHeaviest() throws PokemonException {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HEAVY);
    }

    @Override
    public PokemonInfoDto topFiveHighest() throws PokemonException {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HIGH);
    }

    @Override
    public PokemonInfoDto topFiveBaseExperienced() throws PokemonException {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.BASE_EXPERIENCE);
    }
}
