package org.jfdelolmo.pokeapi.rest;

import org.jfdelolmo.pokeapi.dto.PokemonInfoDto;
import org.jfdelolmo.pokeapi.exception.PokemonException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pokeapi/red/top")
public interface RestControllerApi {

    @GetMapping("/heaviest")
    PokemonInfoDto topFiveHeaviest() throws PokemonException;

    @GetMapping("/highest")
    PokemonInfoDto topFiveHighest() throws PokemonException;

    @GetMapping("/experienced")
    PokemonInfoDto topFiveBaseExperienced() throws PokemonException;

}
