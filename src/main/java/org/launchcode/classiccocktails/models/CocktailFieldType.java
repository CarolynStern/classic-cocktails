package org.launchcode.classiccocktails.models;

public enum CocktailFieldType {
    NAME ("Name"),
    INGREDIENT ("Ingredient"),
    ALL ("All");

    private final String name;

    CocktailFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

