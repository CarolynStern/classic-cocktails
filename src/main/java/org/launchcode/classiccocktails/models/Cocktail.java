package org.launchcode.classiccocktails.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Cocktail {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, message = "The name of the cocktail must be at least 3 characters long")
    private String name;

    @NotNull
    @Size(min=1, message = "Must have at least one ingredient")
    private String ingredient;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "cocktails")
    private List<CocktailList> cocktailLists;


    public Cocktail (int id, String name, String ingredient) {

        this();

        this.id = id;
        this.name= name;
        this.ingredient = ingredient;
    }

    public Cocktail (){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) {this.category = category; }
}
