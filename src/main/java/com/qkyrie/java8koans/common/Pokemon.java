package com.qkyrie.java8koans.common;

/**
 * User: Quinten
 * Date: 1-4-2014
 * Time: 21:38
 *
 * @author Quinten De Swaef
 */
public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;

    public Pokemon(int id, String name, int height, int weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        if (height != pokemon.height) return false;
        if (id != pokemon.id) return false;
        if (weight != pokemon.weight) return false;
        if (name != null ? !name.equals(pokemon.name) : pokemon.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + weight;
        return result;
    }
}
