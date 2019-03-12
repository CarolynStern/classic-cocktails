package org.launchcode.classiccocktails.models.forms;



import org.launchcode.classiccocktails.models.Cocktail;
import org.launchcode.classiccocktails.models.CocktailList;

import javax.validation.constraints.NotNull;

public class AddCocktailListItemsForm {
    private CocktailList cocktailList;

    private Iterable<Cocktail> cocktails;

    @NotNull
    private int cocktailListId;

    @NotNull
    private int cocktailId;

    public AddCocktailListItemsForm(CocktailList cocktailList, Iterable<Cocktail> cocktails) {
        this.cocktailList = cocktailList;
        this.cocktails = cocktails;
    }

    public AddCocktailListItemsForm(){}

    public CocktailList getCocktailList() {
        return cocktailList;
    }

    public Iterable<Cocktail> getCocktails() {
        return cocktails;
    }

    public int getCocktailListId() {
        return cocktailListId;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailListId(int cocktailListId) {
        this.cocktailListId = cocktailListId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }
}
