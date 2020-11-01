package org.jfdelolmo.pokeapi.services.client;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.stereotype.Component;

@Component
public class PokeApiFactoryImpl implements PokeApiFactory {

    public PokeApi createInstance() {
        return new PokeApiClient();
    }

}
