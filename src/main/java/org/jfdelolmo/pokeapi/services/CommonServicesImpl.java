package org.jfdelolmo.pokeapi.services;

import lombok.AllArgsConstructor;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.model.FilterCriteriaEnum;
import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.jfdelolmo.pokeapi.repository.PokeRepository;
import org.jfdelolmo.pokeapi.services.mapper.ModelToDtoMapper;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class CommonServicesImpl implements CommonServices {

    private static final Map<FilterCriteriaEnum, String> filterCriteriaMap = Collections.unmodifiableMap(
            Stream.of(
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.BASE_EXPERIENCE, "baseExperience"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HEAVY, "weight"),
                    new AbstractMap.SimpleEntry<>(FilterCriteriaEnum.HIGH, "height")
            ).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue))
    );

    private final PokeRepository repository;

    @Override
    public PokemonInfoDto getPokemonInfo(int top, FilterCriteriaEnum filterCriteriaEnum) throws PokemonException {
        PokemonInfoDto output = new PokemonInfoDto();
        try {
            List<PokemonModel> fromRepository = repository.findTop(top, getTopCriteria(filterCriteriaEnum));
            output.getPokemons().addAll(fromRepository.stream()
                    .map(ModelToDtoMapper::pokemonModelToPokemonDetailDto)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new PokemonException("It seems that your pokedex is broken!");
        }
        return output;
    }

    /**
     * Responsible of mapping the filterCriteriaEnum to the name of the top sorting column
     *
     * @param filterCriteriaEnum The FilterCriteriaEnum value
     * @return The name of the top sorting column
     */
    private String getTopCriteria(FilterCriteriaEnum filterCriteriaEnum) {
        return filterCriteriaMap.get(filterCriteriaEnum);
    }

}
