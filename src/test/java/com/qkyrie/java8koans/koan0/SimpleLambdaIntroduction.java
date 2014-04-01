package com.qkyrie.java8koans.koan0;

import com.qkyrie.java8koans.common.Pokemon;
import com.qkyrie.java8koans.common.PokemonDataReader;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 10:04
 *
 * @author Quinten De Swaef
 */
public class SimpleLambdaIntroduction {

    @Test
    public void introduction() {
        /**
         * This section will be a basic introduction on how lambdas work.
         * We advise you to read through
         * http://viralpatel.net/blogs/lambda-expressions-java-tutorial/
         *
         * Lambdas might seem a bit complex at first glance, but don't be afraid.
         * You'll quickly get the hang of it and you'll start to embrace their beauty.
         */

        boolean iHaveReadTheBasicsAboutLambdas = false;

        /* <make your changes here> */

        iHaveReadTheBasicsAboutLambdas = true;

        /* </make your changes here> */

        assertThat(iHaveReadTheBasicsAboutLambdas).isTrue();
    }

    @Test
    public void implementAFunctionalInterface() {

        /**
         * As a lambda is actually an implementation of a functional interface,
         * we'll quickly check if you understand how this works.
         *
         * Below you'll see a Runnable being implemented the 'old fashion' way,
         * it's up to you to implement it using a oneliner/lambda
         *
         * We'll use a mocked printstream which we can call in our runnable.
         */
        PrintStream mockedPrintStream = mock(PrintStream.class);

        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                mockedPrintStream.println("Hello Pokemon!");
            }
        };

        Runnable newRunnable;

        /* <make your changes here> */

        newRunnable = () -> mockedPrintStream.println("Hello Pokemon!");

        /* </make your changes here> */

        execute(oldRunnable);
        execute(newRunnable);
        verify(mockedPrintStream, times(2)).println("Hello Pokemon!");
    }

    @Test
    public void iteratingThroughAList() {
        /**
         * Iteration through a list has always been cumbersome. Ok, we got some nice improvements
         * with the 'enhanced for loop', but still.. We've been writing in an imperative way for
         * much too long. Time has come! First two examples show the old, imperative way of iterating
         * through a loop and printing out values. It's up to you to change this into a declarative way using
         * lambda expressions.
         *
         * TIP: checkout the forEach method (available on any collection)
         * which accepts a Consumer method (Lambda).
         *
         * We'll be using PokemonDataReader to fetch all the pokemon, and write their names to the outputstream
         */
        PokemonDataReader reader = PokemonDataReader.newInstance();
        PrintStream mockedPrintStream = mock(PrintStream.class);

        /*
            The old way, we need to initialize a value, tell it what we're counting
            towards and
         */
        List<Pokemon> pokemon = reader.getPokemon();
        for(int i = 0; i < pokemon.size(); i++) {
            mockedPrintStream.println(pokemon.get(i).getName());
        }

        /*
            enhanced for way
         */
        for (Pokemon pokemonElement : reader.getPokemon()) {
            mockedPrintStream.println(pokemonElement.getName());
        }

        /*
            lambda way
         */

        /* <make your changes here> */

        reader.getPokemon().forEach(pokimanz -> mockedPrintStream.println(pokimanz.getName()));

        /* </make your changes here> */

        verify(mockedPrintStream, times(353)).println(any(String.class));
    }


    //utility methods
    private void execute(Runnable runnable) {
        runnable.run();
    }

}
