package org.jfdelolmo.pokeapi.services;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.model.FilterCriteriaEnum;
import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.jfdelolmo.pokeapi.repository.PokeRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommonServicesImplTest {

    private static final int MOCKED_TOP = 1;
    private static final FilterCriteriaEnum MOCKED_FILTER_CRITERIA = FilterCriteriaEnum.BASE_EXPERIENCE;

    public static final PokeRepository repository = mock(PokeRepository.class);

    private final CommonServices service = new CommonServicesImpl(repository);

    @Test
    void getPokemonInfo() throws Exception {
        //Given
        List<PokemonModel> mockedModelList = initMockedModelList();
        when(repository.findTop(any(), any())).thenReturn(mockedModelList);

        //When
        PokemonInfoDto result = service.getPokemonInfo(MOCKED_TOP, MOCKED_FILTER_CRITERIA);

        //Then
        assertThat(result).isNotNull();
        assertThat(result.getPokemons()).isNotNull();
        assertThat(result.getPokemons().size()).isEqualTo(1);
    }

    private List<PokemonModel> initMockedModelList() {
        List<PokemonModel> listOfModels = new ArrayList<>();
        listOfModels.add(MockDataProvider.mockedPokemonModel());
        return listOfModels;
    }

}