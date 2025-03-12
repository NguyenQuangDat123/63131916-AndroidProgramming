package com.example.vd_customlistview;

public class Country {
    private String name;
    private String population;
    private int imageResId;

    public Country(String name, String population, int imageResId) {
        this.name = name;
        this.population = population;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public int getImageResId() {
        return imageResId;
    }
}
