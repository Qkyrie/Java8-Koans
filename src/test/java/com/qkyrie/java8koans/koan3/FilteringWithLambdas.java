package com.qkyrie.java8koans.koan3;

import com.qkyrie.java8koans.common.Koan;
import com.qkyrie.java8koans.common.Pokemon;
import com.qkyrie.java8koans.common.PokemonDataReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 09:56
 *
 * @author Quinten De Swaef
 */
@Koan
public class FilteringWithLambdas {

    @Test
    public void filterThesePokemon() {
        /**
         * Filtering out values from a collection has always been a hard task. You had to
         * create a new collection, loop through the whole thing, and add the values that corresponded
         * to your predicate.
         *
         * All of this can be leveraged by the smart use of the filter function, available on any
         * stream on a collection.
         *
         * Below you'll find an example of how we used to do it. It's up to you to create the predicate
         * to which the value needs to correspond to.
         *
         * We will fetch all the pokemon who's names start with a b.
         */

        List<Pokemon> allPokemon = allPokemon();

        /*
            Old way
         */
        List<Pokemon> oldPokemonStartingWithB = new ArrayList<>();
        for (Pokemon pokemon : allPokemon) {
            if(pokemon.getName().toUpperCase().startsWith("B")) {
                oldPokemonStartingWithB.add(pokemon);
            }
        }


        /*
            Here's the new way
         */

        Predicate<Pokemon> predicateForPokemonWithNamesStartingWithB = null;

        /* <make your changes here> */

        predicateForPokemonWithNamesStartingWithB = pokemon -> pokemon.getName().toUpperCase().startsWith("B");

        /* </make your changes here> */


        List<Pokemon> newPokemonStartingWithB = allPokemon.stream()
                .filter(predicateForPokemonWithNamesStartingWithB).distinct()
                .collect(Collectors.toList());

        assertThat(newPokemonStartingWithB).isEqualTo(oldPokemonStartingWithB);
    }

    private List<Pokemon> allPokemon() {
        return PokemonDataReader.newInstance().getPokemon();
    }
}
