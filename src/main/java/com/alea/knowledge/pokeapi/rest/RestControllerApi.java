package com.alea.knowledge.pokeapi.rest;

import com.alea.knowledge.pokeapi.dto.PokemonInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/alea/pokeapi/top/five/red")
public interface RestControllerApi {

    //The 5 heaviest Pokémons.
    @GetMapping("/heaviest")
    ResponseEntity<PokemonInfoDto> topFiveHeaviest() throws Exception;

    //The 5 highest Pokémons.
    @GetMapping("/highest")
    ResponseEntity<PokemonInfoDto> topFiveHighest() throws Exception;

    //The 5 Pokémons with more base experience.
    @GetMapping("/experienced")
    ResponseEntity<PokemonInfoDto> topFiveBaseExperienced() throws Exception;

}
