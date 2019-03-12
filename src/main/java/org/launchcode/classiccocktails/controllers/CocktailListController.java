package org.launchcode.classiccocktails.controllers;

import org.launchcode.classiccocktails.models.Cocktail;
import org.launchcode.classiccocktails.models.CocktailList;
import org.launchcode.classiccocktails.models.data.CocktailDao;
import org.launchcode.classiccocktails.models.data.CocktailListDao;
import org.launchcode.classiccocktails.models.forms.AddCocktailListItemsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("cocktail-list")
public class CocktailListController {

    @Autowired
    private CocktailListDao cocktailListDao;

    @Autowired
    private CocktailDao cocktailDao;

    @RequestMapping(value ="")
    public String index(Model model){
        model.addAttribute("cocktailLists", cocktailListDao.findAll());
        model.addAttribute("title", "My Cocktail Lists");
        return "cocktail-list/index"; }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String viewAddCocktailList(Model model) {
        model.addAttribute(new CocktailList());
        model.addAttribute("title", "Add a Cocktail List");
        return "cocktail-list/add"; }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCocktailList(@ModelAttribute @Valid CocktailList cocktailList,
                                 Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a Cocktail List");
            return "cocktail-list/add"; }
        cocktailListDao.save(cocktailList);
        return "redirect:view/" + cocktailList.getId();
    }

    @RequestMapping(value="view/{cocktailListId}", method = RequestMethod.GET)
    public String viewCocktailList(Model model, @PathVariable int cocktailListId){
        CocktailList cocktailList = cocktailListDao.findOne(cocktailListId);
        model.addAttribute("cocktailList", cocktailList);
        model.addAttribute("cocktailListId", cocktailList.getId());
        return "cocktail-list/view";
    }

    @RequestMapping(value="add-item/{cocktailListId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int cocktailListId){
       CocktailList cocktailList = cocktailListDao.findOne(cocktailListId);
        AddCocktailListItemsForm form = new AddCocktailListItemsForm(cocktailList, cocktailDao.findAll());
        model.addAttribute("form", form);
        model.addAttribute("title", "Add cocktail to list: " + cocktailList.getName());
        return "cocktail-list/add-item";
    }

    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddCocktailListItemsForm form, Errors errors){
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "cocktail-list/add-item";
        }
        Cocktail theCocktail = cocktailDao.findOne(form.getCocktailId());
        CocktailList theCocktailList = cocktailListDao.findOne(form.getCocktailListId());
        theCocktailList.addItem(theCocktail);
        cocktailListDao.save(theCocktailList);
        return "redirect:/cocktail-list/view/" + theCocktailList.getId();
    }
}
