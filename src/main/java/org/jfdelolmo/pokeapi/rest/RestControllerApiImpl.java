package org.jfdelolmo.pokeapi.rest;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.jfdelolmo.pokeapi.services.domain.TopFiveDomainService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApiImpl implements RestControllerApi {

    private final TopFiveDomainService service;

    public RestControllerApiImpl(TopFiveDomainService service) {
        this.service = service;
    }

    @Override
    public PokemonInfoDto topFiveHeaviest() throws PokemonException {
        return service.topFiveHeaviest();
    }

    @Override
    public PokemonInfoDto topFiveHighest() throws PokemonException {
        return service.topFiveHighest();
    }

    @Override
    public PokemonInfoDto topFiveBaseExperienced() throws PokemonException {
        return service.topFiveBaseExperienced();
    }
}
