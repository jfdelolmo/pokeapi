package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.domain.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopFiveDomainServiceImpl implements TopFiveDomainService {

    /**
     * Used to indicate the number of items
     */
    private static final int TOP = 5;

    private final CommonServices commonServices;

    @Override
    public CommonWrapper<PokemonInfoDto> topFiveHeaviest() throws Exception {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HEAVY);
    }

    @Override
    public CommonWrapper<PokemonInfoDto> topFiveHighest() throws Exception {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.HIGH);
    }

    @Override
    public CommonWrapper<PokemonInfoDto> topFiveBaseExperienced() throws Exception {
        return commonServices.getPokemonInfo(TOP, FilterCriteriaEnum.BASE_EXPERIENCE);
    }
}
