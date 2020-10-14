package com.alea.knowledge.pokeapi.rest;

import com.alea.knowledge.pokeapi.dto.CommonWrapper;
import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import com.alea.knowledge.pokeapi.services.TopFiveDomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApiImpl implements RestControllerApi {

    private TopFiveDomainService service;

    public RestControllerApiImpl(TopFiveDomainService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveHeaviest() throws Exception {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveHeaviest();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveHighest() throws Exception {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveHighest();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }

    @Override
    public ResponseEntity<PokemonInfoDto> topFiveBaseExperienced() throws Exception {
        CommonWrapper<PokemonInfoDto> responseData = service.topFiveBaseExperienced();
        return ResponseEntity.status(responseData.getHttpStatus())
                .body(responseData.getDto());
    }
}
