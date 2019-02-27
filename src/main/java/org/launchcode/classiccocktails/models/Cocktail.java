package org.launchcode.classiccocktails.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Cocktail {
    @Id
    @GeneratedValue
    private int cocktailId;

    @NotNull
    @Size(min=3, message = "The name of the cocktail must be at least 3 characters long")
    private Name name;

    @NotNull
    @Size(min=1, message = "Must have at least one ingredient")
    private Ingredient ingredient;

    public Cocktail (int id, Name name, Ingredient ingredient) {

        this();

        this.cocktailId = id;
        this.name= name;
        this.ingredient = ingredient;
    }

    public Cocktail (){}

    public int getCocktailId() {
        return cocktailId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
