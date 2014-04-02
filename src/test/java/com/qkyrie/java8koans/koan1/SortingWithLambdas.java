package com.qkyrie.java8koans.koan1;

import com.qkyrie.java8koans.common.Koan;
import com.qkyrie.java8koans.common.Pokemon;
import com.qkyrie.java8koans.common.PokemonDataReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 09:52
 *
 * @author Quinten De Swaef
 */
@Koan
public class SortingWithLambdas {

    @Test
    public void basicSorting() {
        /**
         * If we check out the new stream api, which is available on all collections,
         * we quickly notice that sorting has become a lot easier.
         *
         * In the past, we had to implement our own sorting algorithm, implementing
         * the Compare interface. The Compare interface is a functional interface
         * and can therefore be written as a lambda expression.
         *
         * Below you'll see the old way of sorting all pokemon by name.
         * It's up to you to sort them using a lambda expression. We advise you to
         */

        List<Pokemon> oldSortedPokemon = getUnsortedPokemon();

        oldSortedPokemon.sort(new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon firstPokemon, Pokemon secondPokemon) {
                return firstPokemon.getName().compareTo(secondPokemon.getName());
            }
        });

        List<Pokemon> unsortedPokemon = getUnsortedPokemon();
        List<Pokemon> newlySortedPokemon = null;

        /* <make your changes here> */

        newlySortedPokemon = unsortedPokemon.stream()
                .sorted((pokemon1, pokemon2) -> pokemon1.getName().compareTo(pokemon2.getName()))
                .collect(Collectors.toList());

        /* </make your changes here> */

        assertThat(oldSortedPokemon).isEqualTo(newlySortedPokemon);

    }

    @Test
    public void someMoreSorting() {

    }

    //utility methods
    private List<Pokemon> getUnsortedPokemon() {
        return PokemonDataReader.newInstance().getPokemon();
    }

}
