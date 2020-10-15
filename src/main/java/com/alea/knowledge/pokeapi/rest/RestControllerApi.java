package com.alea.knowledge.pokeapi.rest;

import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/alea/pokeapi/top/five/red")
public interface RestControllerApi {

    @GetMapping("/heaviest")
    ResponseEntity<PokemonInfoDto> topFiveHeaviest();

    @GetMapping("/highest")
    ResponseEntity<PokemonInfoDto> topFiveHighest();

    @GetMapping("/experienced")
    ResponseEntity<PokemonInfoDto> topFiveBaseExperienced();

}
