package org.jfdelolmo.pokeapi.rest;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokeExceptionHandler;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.jfdelolmo.pokeapi.services.MockDataProvider;
import org.jfdelolmo.pokeapi.services.domain.TopFiveDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RestControllerApiImplTest {

    private static final String BASE_URL = "/pokeapi/red/top";
    private static final String CONTENT_TYPE = "application/json";

    private MockMvc mockMvc;

    private final TopFiveDomainService topFiveDomainService = mock(TopFiveDomainService.class);

    private final PokemonInfoDto successMockedWrapper = MockDataProvider.mockedPokemonInfo();

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RestControllerApiImpl(topFiveDomainService))
                .setControllerAdvice(new PokeExceptionHandler())
                .build();
    }

    @Test
    void topFiveHeaviest() throws Exception {
        //Given
        when(topFiveDomainService.topFiveHeaviest()).thenReturn(successMockedWrapper);

        //When
        mockMvc.perform(get(BASE_URL + "/heaviest"))
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pokemons").exists());

        //Then
        verify(topFiveDomainService, times(1)).topFiveHeaviest();
    }

    @Test
    void topFiveHighest() throws Exception {
        //Given
        when(topFiveDomainService.topFiveHighest()).thenReturn(successMockedWrapper);

        //When
        mockMvc.perform(get(BASE_URL + "/highest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.pokemons").exists());

        //Then
        verify(topFiveDomainService, times(1)).topFiveHighest();
    }

    @Test
    void topFiveBaseExperienced() throws Exception {
        //Given
        when(topFiveDomainService.topFiveBaseExperienced()).thenReturn(successMockedWrapper);

        //When
        mockMvc.perform(get(BASE_URL + "/experienced"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.pokemons").exists());

        //Then
        verify(topFiveDomainService, times(1)).topFiveBaseExperienced();
    }

    @Test
    void failedServiceCall() throws Exception {
        //Given
        when(topFiveDomainService.topFiveBaseExperienced()).thenThrow(new PokemonException("This is a mocked error"));

        //When
        mockMvc.perform(get(BASE_URL + "/experienced"))
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().string("This is a mocked error"));

        //Then
        verify(topFiveDomainService, times(1)).topFiveBaseExperienced();
    }
}