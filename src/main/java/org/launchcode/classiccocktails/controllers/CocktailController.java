package org.launchcode.classiccocktails.controllers;

import org.launchcode.classiccocktails.models.Category;
import org.launchcode.classiccocktails.models.Cocktail;
import org.launchcode.classiccocktails.models.data.CategoryDao;
import org.launchcode.classiccocktails.models.data.CocktailDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("cocktail")
public class CocktailController {

    @Autowired
    CocktailDao cocktailDao;


    @Autowired
    CategoryDao categoryDao;

    // Request path: /cocktail
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cocktails", cocktailDao.findAll());
        model.addAttribute("title", "My Cocktails");

        return "cocktail/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCocktailForm(Model model) {
        model.addAttribute("title", "Add Cocktail");
        model.addAttribute(new Cocktail());
        model.addAttribute("categories", categoryDao.findAll());

        return "cocktail/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCocktailForm(@ModelAttribute  @Valid Cocktail newCocktail,
                                       Errors errors, @RequestParam int categoryId, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cocktail");
            return "cocktail/add";
        }

        Category cat= categoryDao.findOne(categoryId);
        newCocktail.setCategory(cat);
        cocktailDao.save(newCocktail);
        return "redirect:";

    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCocktailForm(Model model) {
        model.addAttribute("cocktails", cocktailDao.findAll());
        model.addAttribute("title", "Remove Cocktail");
        return "cocktail/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCocktailForm(@RequestParam int[] cocktailIds) {

        for (int cocktailId : cocktailIds) {
            cocktailDao.delete(cocktailId);
        }

        return "redirect:";
    }

}
