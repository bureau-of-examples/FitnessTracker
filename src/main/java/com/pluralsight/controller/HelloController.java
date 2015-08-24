package com.pluralsight.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

@Controller
@RequestMapping
@SessionAttributes("modifiedTime")
public class HelloController implements ApplicationContextAware {

    private static final String TEXT_ENCODING = "UTF-8";

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam("name") String name, Model model) throws UnsupportedEncodingException{

        Object[] args = {HtmlUtils.htmlEscape(UriUtils.decode(name, TEXT_ENCODING)), new Date()};
        String message = applicationContext.getMessage("hello.greating.message", args, LocaleContextHolder.getLocale());
        model.addAttribute("greeting", message);
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

    @RequestMapping(value = "lastModified", method = RequestMethod.GET)
    public String lastModifiedTest(WebRequest request, HttpSession session, @RequestParam(required = false) String update, Model model, final HttpServletResponse response){

        Date modifiedTime = (Date)session.getAttribute("modifiedTime");

        if(modifiedTime == null || !StringUtils.isEmpty(update)){
            modifiedTime = new Date();
        }

        response.setHeader("Cache-Control", "max-age=3600");

        if(request.checkNotModified(modifiedTime.getTime())) {
            return null;
        }

        model.addAttribute("modifiedTime", modifiedTime);
        model.addAttribute("now", new Date());

        return "lastModified";
    }

    @RequestMapping(value = "cache", method = RequestMethod.GET)
    public String cacheTest(Model model, HttpServletResponse response){
        model.addAttribute("now", new Date());
        response.setHeader("Cache-Control", "private, max-age=60");
        response.setDateHeader("Expires", Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime().getTime());
        response.setHeader("Pragma", "");
        return "cache";
    }

}
