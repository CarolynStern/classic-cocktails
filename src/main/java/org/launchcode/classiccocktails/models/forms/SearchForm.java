package org.launchcode.classiccocktails.models.forms;

import org.launchcode.classiccocktails.models.CocktailFieldType;

public class SearchForm {

    // The search options
    private CocktailFieldType[] fields = CocktailFieldType.values();

    // The selected search options
    private CocktailFieldType searchField = CocktailFieldType.ALL;

    // The search string
    private String keyword;

    public CocktailFieldType getSearchField() {
        return searchField;
    }

    public void setSearchField(CocktailFieldType searchField) {
        this.searchField = searchField;
    }

    public CocktailFieldType[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}