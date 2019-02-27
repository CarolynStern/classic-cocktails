package org.launchcode.classiccocktails.controllers;

import org.launchcode.classiccocktails.models.Cocktail;
import org.launchcode.classiccocktails.models.CocktailFieldType;
import org.launchcode.classiccocktails.models.data.CocktailData;
import org.launchcode.classiccocktails.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    private CocktailData cocktailData = CocktailData.getInstance();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Cocktail> cocktails;

        if (searchForm.getSearchField().equals(CocktailFieldType.ALL)) {
            cocktails = cocktailData.findByValue(searchForm.getKeyword());
        } else {
            cocktails = cocktailData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }

        model.addAttribute("cocktails", cocktails);

        return "search/results";
    }

}
