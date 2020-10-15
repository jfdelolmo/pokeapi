package com.alea.knowledge.pokeapi.rest;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.services.domain.TopFiveDomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApiImpl implements RestControllerApi {

    private final TopFiveDomainService service;

    public RestControllerApiImpl(TopFiveDomainService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveHeaviest() {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveHeaviest();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveHighest() {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveHighest();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveBaseExperienced() {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveBaseExperienced();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }
}
