package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.model.PokemonModel;
import com.alea.knowledge.pokeapi.repository.PokeRepository;
import com.alea.knowledge.pokeapi.services.mapper.MapUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CommonServicesImpl implements CommonServices {

    private final PokeRepository repository;

    @Override
    public CommonWrapper<PokemonInfoDto> getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum) {
        CommonWrapper<PokemonInfoDto> output = new CommonWrapper<>();
        try {
            List<PokemonModel> fromRepository = repository.findTop(top, MapUtils.getTopCriteria(filterCriteriaEnum));
            output.setDto(prepareDataFromRepository(fromRepository));
            output.setHttpStatus(HttpStatus.OK);
        } catch (Exception e) {
            PokemonInfoDto info = new PokemonInfoDto();
            info.setError("It seems that your pokedex is broken!");
            output.setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return output;
    }

    private PokemonInfoDto prepareDataFromRepository(List<PokemonModel> fromRepository) {
        PokemonInfoDto pokemonInfoDto = new PokemonInfoDto();
        pokemonInfoDto.setPokemons(
                fromRepository
                        .stream()
                        .map(MapUtils::modelToDetailDto)
                        .collect(Collectors.toList())
        );
        return pokemonInfoDto;
    }

}
