package com.alea.knowledge.pokeapi.services;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.model.FilterCriteriaEnum;
import com.alea.knowledge.pokeapi.model.PokemonModel;
import com.alea.knowledge.pokeapi.repository.PokeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommonServicesImplTest {

    private static final int MOCKED_TOP = 1;
    private static final FilterCriteriaEnum MOCKED_FILTER_CRITERIA = FilterCriteriaEnum.BASE_EXPERIENCE;

    public PokeRepository repository = mock(PokeRepository.class);

    private CommonServices service = new CommonServicesImpl(repository);

    @Test
    void getPokemonInfo() {
        List<PokemonModel> mockedModelList = initMockedModelList();
        when(repository.findTop(any(), any())).thenReturn(mockedModelList);

        CommonWrapper<PokemonInfoDto> result = service.getPokemonInfo(MOCKED_TOP, MOCKED_FILTER_CRITERIA);

        assertThat(result).isNotNull();
        assertThat(result.getDto()).isNotNull();
        assertThat(result.getDto().getError()).isNull();
        assertThat(result.getDto().getPokemons()).isNotNull();
        assertThat(result.getDto().getPokemons().size()).isEqualTo(1);
        assertThat(result.getHttpStatus()).isEqualByComparingTo(HttpStatus.OK);
    }

    private List<PokemonModel> initMockedModelList() {
        List<PokemonModel> listOfModels = new ArrayList<>();
        listOfModels.add(MockDataProvider.mockedPokemonModel());
        return listOfModels;
    }

}