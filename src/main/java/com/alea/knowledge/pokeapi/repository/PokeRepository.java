package com.alea.knowledge.pokeapi.repository;

import com.alea.knowledge.pokeapi.model.PokemonModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PokeRepository extends JpaRepository<PokemonModel, Long> {

    default List<PokemonModel> findTop(Integer top, String propertyName) {
        List<PokemonModel> result = new ArrayList<>();

        Iterable<PokemonModel> page = findAll(
                PageRequest.of(0, top, Sort.by(Sort.Direction.DESC, propertyName)));

        page.forEach(result::add);

        return result;

    }

}
