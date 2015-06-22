package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping
public class HelloController implements LastModified { //todo LastModified not working


    @RequestMapping("/greeting")
    public String sayHello(Model model) {

        model.addAttribute("greeting", "Hello World @" + new Date() + "!");
        return "hello";
    }

    @RequestMapping(value = {"/params/{id}"})
    public String requestParams(@PathVariable("id") Integer id, @RequestHeader("User-Agent") String userAgent,  Model model) {
        model.addAttribute("id", id);
        model.addAttribute("userAgent", userAgent);
        return "params";
    }


    public long getLastModified(HttpServletRequest httpServletRequest) {
        Date now = new Date();
        now.setSeconds(0);
        return now.getTime();
    }


}
