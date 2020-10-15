package com.alea.knowledge.pokeapi.rest;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.services.MockDataProvider;
import com.alea.knowledge.pokeapi.services.domain.TopFiveDomainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RestControllerApiImplTest {

    private static final String BASE_URL = "/alea/pokeapi/top/five/red";
    private static final String CONTENT_TYPE = "application/json";

    private MockMvc mockMvc;

    private final TopFiveDomainService topFiveDomainService = mock(TopFiveDomainService.class);

    private final CommonWrapper<PokemonInfoDto> successMockedWrapper = MockDataProvider.initMockedWrapper(HttpStatus.OK);
    private final CommonWrapper<PokemonInfoDto> failMockedWrapper = MockDataProvider.initMockedWrapper(HttpStatus.I_AM_A_TEAPOT);

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RestControllerApiImpl(topFiveDomainService))
                .build();
    }

    @Test
    void topFiveHeaviest() throws Exception {
        when(topFiveDomainService.topFiveHeaviest()).thenReturn(successMockedWrapper);

        mockMvc.perform(get(BASE_URL + "/heaviest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.pokemons").exists());


        verify(topFiveDomainService, times(1)).topFiveHeaviest();
    }

    @Test
    void topFiveHighest() throws Exception {
        when(topFiveDomainService.topFiveHighest()).thenReturn(successMockedWrapper);

        mockMvc.perform(get(BASE_URL + "/highest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.pokemons").exists());


        verify(topFiveDomainService, times(1)).topFiveHighest();
    }

    @Test
    void topFiveBaseExperienced() throws Exception {
        when(topFiveDomainService.topFiveBaseExperienced()).thenReturn(successMockedWrapper);

        mockMvc.perform(get(BASE_URL + "/experienced"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.error").isEmpty())
                .andExpect(jsonPath("$.pokemons").exists());


        verify(topFiveDomainService, times(1)).topFiveBaseExperienced();
    }

    @Test
    void failedServiceCall() throws Exception {
        when(topFiveDomainService.topFiveBaseExperienced()).thenReturn(failMockedWrapper);

        mockMvc.perform(get(BASE_URL + "/experienced"))
                .andExpect(status().isIAmATeapot())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.error").value("This is a mocked error"))
                .andExpect(jsonPath("$.pokemons").exists());


        verify(topFiveDomainService, times(1)).topFiveBaseExperienced();
    }
}