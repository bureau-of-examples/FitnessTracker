package com.pluralsight.aop;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.pluralsight.controller")
public class BasePackageAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView gotoErrorPage(Exception ex){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("errorMessage", ex.getLocalizedMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
