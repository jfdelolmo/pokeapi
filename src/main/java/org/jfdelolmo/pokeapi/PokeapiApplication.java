package org.jfdelolmo.pokeapi;

import org.jfdelolmo.pokeapi.services.loader.PokemonDataLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication()
public class PokeapiApplication {

    private final PokemonDataLoader loader;

    public PokeapiApplication(PokemonDataLoader loader) {
        this.loader = loader;
    }

    public static void main(String[] args) {
        SpringApplication.run(PokeapiApplication.class, args);
    }

    @PostConstruct
    public void initDatabase() {
        loader.initializeDataBase();
    }
}
