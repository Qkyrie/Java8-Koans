package com.qkyrie.java8koans.common;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 10:18
 *
 * @author Quinten De Swaef
 */
public class PokemonDataReader {

    public static final String POKEMON_CSV = "pokemon.csv";

    public List<String[]> getPokemonData() {
        try {
            URL dir_url = ClassLoader.getSystemResource(POKEMON_CSV);
            File dir = new File(dir_url.toURI());
            Reader reader = new FileReader(dir);
            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            return csvParser.readAll();
        } catch (IOException | URISyntaxException e) {
            return new ArrayList<>();
        }
    }

    public List<Pokemon> getPokemon() {
        return getPokemonData().stream().map((aPokemon) -> new Pokemon
                (
                        Integer.valueOf(aPokemon[0]),
                        aPokemon[1],
                        Integer.valueOf(aPokemon[3]),
                        Integer.valueOf(aPokemon[4])
                )).collect(Collectors.toList());
    }


}
