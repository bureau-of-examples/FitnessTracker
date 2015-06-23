package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.LastModified;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping
public class HelloController { //todo LastModified not working

    private static final String TEXT_ENCODING = "UTF-8";

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam("name") String name, Model model) throws UnsupportedEncodingException{

        model.addAttribute("greeting", "Hello " + HtmlUtils.htmlEscape(UriUtils.decode(name, TEXT_ENCODING)) +"! The time is " + new Date() + "!");
        return "hello";
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){
        return "sayHello";
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    public String sayHello(@RequestParam("name") String name, Model model) throws UnsupportedEncodingException{
        model.addAttribute("userName", UriUtils.encodeQueryParam(name,TEXT_ENCODING));
        return "redirect:greeting.html?name={userName}";
    }

    @RequestMapping(value = {"/params/{id}"})
    public String requestParams(@PathVariable("id") Integer id, @RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID") String cookie, /*doesn't work before extension*/@MatrixVariable(pathVar = "id") Map<String, String> matrixVariables,  Model model) {
        model.addAttribute("id", id);
        model.addAttribute("userAgent", userAgent);
        model.addAttribute("matrixVariables", matrixVariables);
        model.addAttribute("JSESSIONID", cookie) ;

        return "params";
    }

    @RequestMapping(value = {"/params/{id}/matrix"})
    public String dumpMatrixVariables(@PathVariable("id") Integer id, /*works*/@MatrixVariable(pathVar = "id") Map<String, String> matrixVariables,  Model model){
        model.addAttribute("id", id);
        model.addAttribute("matrixVariables", matrixVariables);

        return "params";
    }

    @RequestMapping(value = "/redirect/{redirectValue}", method = RequestMethod.GET)
    public String redirectAttributeTest(@ModelAttribute("redirectValue") @PathVariable("redirectValue") String redirectValue, RedirectAttributesModelMap redirectAttributes){
        redirectAttributes.addAttribute("redirectValue", redirectValue);
        redirectAttributes.addFlashAttribute("flashAttribute", "Flash attribute value");

        return "redirect:/redirected.html";
    }

    @RequestMapping(value = "redirected", method = RequestMethod.GET)
    public String redirected(@ModelAttribute("redirectValue") String redirectValue, @ModelAttribute("flashAttribute") String flashAttribute){
        return "redirected";
    }



}
