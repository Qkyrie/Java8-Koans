package com.qkyrie.java8koans;

import com.qkyrie.java8koans.common.Koan;
import com.qkyrie.java8koans.common.Pokemon;
import com.qkyrie.java8koans.common.PokemonDataReader;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: Quinten
 * Date: 26-3-2014
 * Time: 19:13
 *
 * @author Quinten De Swaef
 */
@Koan
public class Introduction {

    @Test
    public void welcome() {
        /*
         *  Welcome to a collection of koans to get you familiar with some new
         *  features Java 8 has to offer.
         *
         *  To make sure this is compiling against Java version 8,
         *  simply run this test!
         */
        assertThat(System.getProperty("java.version"), startsWith("1.8"));
    }

    @Test
    public void mo(){
        /*
         *  Although we like some everyday koans, sometimes we feel as if it
         *  is not very interesting, entertaining, if you catch my drift.
         *
         *  Therefore we decided to make things a bit more interesting. We'll be
         *  teaching you the new stuff of Java 8 by reminiscing a bit about Pokemon.
         *
         *  Pokemon might just be the most perfect subject to work with, as almost all
         *  software developers will know it. Of course, we'll only focus on the first 151,
         *  as we all know those are the only ones worth mentioning.
         *
         * Just run this test to see if you're able to load the first 151 pokemon
         * from a csv file we added in the resource package. If it does, we're ready
         * to go!
         */

        PokemonDataReader pkmnReader = new PokemonDataReader();
        List<Pokemon> allPokemon = pkmnReader.getPokemon();

        /*
         * We'll just check if the pokemon data is not empty and there are 151 entries
         */
        assertThat(allPokemon.size(), equalTo(151));

        /*
         *  If it succeeds, you can proceed with checking out the first Koan
        */
    }

}
