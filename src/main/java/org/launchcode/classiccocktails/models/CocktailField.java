/*package org.launchcode.classiccocktails.models;

import java.util.ArrayList;

public class CocktailField {
    private String value;
    private int id;
    private static int nextId = 1;

    public CocktailField() {
        id = nextId;
        nextId++;
    }


    public CocktailField(String aValue) {
        this();
        value = aValue;
    }


    public boolean contains(String value) {
        return this.value.contains(value.toLowerCase());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String aValue) {
        value = aValue;
    }

    public String toString() {
        return value;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CocktailField cocktailField = (CocktailField) o;

        return id == cocktailField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
*/


