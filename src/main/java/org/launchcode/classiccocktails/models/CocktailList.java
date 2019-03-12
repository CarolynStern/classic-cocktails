package org.launchcode.classiccocktails.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class
CocktailList {

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private List<Cocktail> cocktails;

    public CocktailList(String name) {
        this.name= name;
    }

    public CocktailList(){}

    public void addItem(Cocktail item) {
        cocktails.add(item);
    }

    public String getName() {return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }
}

