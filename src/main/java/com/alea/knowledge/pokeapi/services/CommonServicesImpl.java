package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.domain.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.domain.PokemonModel;
import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.repository.PokeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class CommonServicesImpl implements CommonServices {

    private final PokeRepository repository;

    private static final Map<FilterCriteriaEnum, String> criteriaMap = Collections.unmodifiableMap(
            Stream.of(
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.BASE_EXPERIENCE, "baseExperience"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HEAVY, "weight"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HIGH, "height")
            ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
    );

    @Override
    public CommonWrapper<PokemonInfoDto> getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum) {
        CommonWrapper<PokemonInfoDto> output = new CommonWrapper<>();
        try {
            List<PokemonModel> fromRepository = repository.findTop(top, criteriaMap.get(filterCriteriaEnum));
            output.setDto(mapFromRepository(fromRepository));
            output.setHttpStatus(HttpStatus.OK);
        } catch (Exception e) {
            PokemonInfoDto info = new PokemonInfoDto();
            info.setError("It seems that your pokedex is broken!");
            output.setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return output;
    }

    private PokemonInfoDto mapFromRepository(List<PokemonModel> fromRepository) {
        PokemonInfoDto pokemonInfoDto = new PokemonInfoDto();
        pokemonInfoDto.setPokemons(
                fromRepository
                        .stream()
                        .map(MapperServiceImpl::modelToDetailDto)
                        .collect(Collectors.toList())
        );
        return pokemonInfoDto;
    }

}
