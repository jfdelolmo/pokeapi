package org.jfdelolmo.pokeapi.repository;

import org.jfdelolmo.pokeapi.model.PokemonModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PokeRepository extends JpaRepository<PokemonModel, Long> {

    /**
     * Default method requesting for a page of 'top' elements sorted descending by the 'propertyName'
     *
     * @param top          Number of elements of the top
     * @param propertyName Name of the property
     * @return A list containing the request top elements
     */
    default List<PokemonModel> findTop(Integer top, String propertyName) {
        List<PokemonModel> result = new ArrayList<>();

        Iterable<PokemonModel> page = findAll(
                PageRequest.of(0, top, Sort.by(Sort.Direction.DESC, propertyName)));

        page.forEach(result::add);

        return result;
    }

}
