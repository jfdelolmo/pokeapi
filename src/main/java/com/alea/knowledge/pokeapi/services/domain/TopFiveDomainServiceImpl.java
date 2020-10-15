package com.alea.knowledge.pokeapi.services.domain;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.services.CommonServices;
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
    public CommonWrapper<PokemonInfoDto> topFiveHeaviest() {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HEAVY);
    }

    @Override
    public CommonWrapper<PokemonInfoDto> topFiveHighest() {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HIGH);
    }

    @Override
    public CommonWrapper<PokemonInfoDto> topFiveBaseExperienced() {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.BASE_EXPERIENCE);
    }
}
