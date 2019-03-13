package org.launchcode.classiccocktails.controllers;

import org.launchcode.classiccocktails.models.User;
import org.launchcode.classiccocktails.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String displayRegisterForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute @Valid User user,
                          Errors errors, String verify) {
        if (errors.hasErrors()) {
            return "user/register";
        }
        userDao.save(user);
        return "redirect:";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayLoginForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Log in");
        return "user/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUser(Model model, @ModelAttribute @Valid User user,
                            Errors errors, String verify) {
        if (errors.hasErrors()) {
            return "user/login";
        }
        return "cocktail/index";
    }
}