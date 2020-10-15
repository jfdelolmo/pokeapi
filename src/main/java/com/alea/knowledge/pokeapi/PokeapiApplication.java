package com.alea.knowledge.pokeapi;

import com.alea.knowledge.pokeapi.configuration.ActuatorAliasConfig;
import com.alea.knowledge.pokeapi.services.loader.PokemonDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication()
@Import(ActuatorAliasConfig.class)
@EntityScan(basePackages = "com.alea.knowledge.pokeapi.model")
@EnableJpaRepositories(basePackages = "com.alea.knowledge.pokeapi.repository")
public class PokeapiApplication {

    private final PokemonDataLoader loader;

    public PokeapiApplication(PokemonDataLoader loader){
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
