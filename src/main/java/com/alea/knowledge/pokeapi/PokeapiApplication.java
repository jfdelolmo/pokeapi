package com.alea.knowledge.pokeapi;

import com.alea.knowledge.pokeapi.services.PokemonDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication()
@EntityScan(basePackages = "com.alea.knowledge.pokeapi.domain")
@EnableJpaRepositories(basePackages = "com.alea.knowledge.pokeapi.repository")
public class PokeapiApplication {

    @Autowired
    PokemonDataLoader loader;

    public static void main(String[] args) {
        SpringApplication.run(PokeapiApplication.class, args);
    }

    @PostConstruct
    public void initDatabase() {
        loader.initializeDataBase();
    }
}
