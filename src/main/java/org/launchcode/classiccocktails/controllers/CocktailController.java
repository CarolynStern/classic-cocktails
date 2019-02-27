package org.launchcode.classiccocktails.controllers;

import org.launchcode.classiccocktails.models.Cocktail;
import org.launchcode.classiccocktails.models.User;
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



