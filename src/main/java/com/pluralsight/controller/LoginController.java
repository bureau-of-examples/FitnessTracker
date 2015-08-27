package com.pluralsight.controller;

import com.pluralsight.model.security.User;
import com.pluralsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute("users", userService.findAllUsers());
        return "login";
    }

    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginFailed(Model model){

        model.addAttribute("error", true);
        return "forward:/login.html";
    }

    @RequestMapping(value = "/loggedOut", method = RequestMethod.GET)
    public String loggedOut(){

        return "loggedOut";
    }

    @RequestMapping(value = "403", method = RequestMethod.GET)
    public String notAuthorized(){

        return "403";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String showUser(Model model, Principal principal){

        String username = principal.getName();
        User currentUser = userService.findUser(username);
        model.addAttribute("user", currentUser);

        return "user";
    }



}
