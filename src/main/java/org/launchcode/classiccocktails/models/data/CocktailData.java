package org.launchcode.classiccocktails.models.data;

import org.launchcode.classiccocktails.models.*;


import java.util.ArrayList;

public class CocktailData {
    private ArrayList<Cocktail> cocktails = new ArrayList<>();
    private static CocktailData instance;

    private CocktailFieldData<Name> names = new CocktailFieldData<>();
    private CocktailFieldData<Ingredient> ingredients = new CocktailFieldData<>();


    public static CocktailData getInstance() {
        if (instance == null) {
            instance = new CocktailData();
        }
        return instance;
    }

    public Cocktail findById(int id) {
        for (Cocktail cocktail : cocktails) {
            if (cocktail.getCocktailId() == id)
                return cocktail;
        }

        return null;
    }

    public ArrayList<Cocktail> findAll() {
        return cocktails;
    }


    public ArrayList<Cocktail> findByColumnAndValue(CocktailFieldType column, String value) {

        ArrayList<Cocktail> matchingCocktails = new ArrayList<>();

        for (Cocktail cocktail : cocktails) {
            if (getFieldByType(cocktail, column).contains(value))
                matchingCocktails.add(cocktail);
        }

        return matchingCocktails;
    }


    public ArrayList<Cocktail> findByValue(String value) {

        ArrayList<Cocktail> matchingCocktails = new ArrayList<>();

        for (Cocktail cocktail : cocktails) {

            if (cocktail.getName().contains(value)) {
                matchingCocktails.add(cocktail);
                continue;
            }

            for (CocktailFieldType column : CocktailFieldType.values()) {
                if (column != CocktailFieldType.ALL && getFieldByType(cocktail, column).contains(value)) {
                    matchingCocktails.add(cocktail);
                    break;
                }
            }
        }

        return matchingCocktails;
    }


    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }


   private static CocktailField getFieldByType(Cocktail cocktail, CocktailFieldType type) {
        switch(type)

    {
        case NAME:
            return cocktail.getName();
        case INGREDIENT:
            return cocktail.getIngredient();
    }

        throw new

    IllegalArgumentException("Cannot get field of type "+type);

}

    public CocktailFieldData<Name> getNames() {
        return names;
    }
    public CocktailFieldData<Ingredient> getIngredients() {
        return ingredients;
    }
}


