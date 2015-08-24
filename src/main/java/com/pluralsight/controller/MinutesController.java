package com.pluralsight.controller;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.repository.ExerciseRepository;
import com.pluralsight.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Objects;

@Controller
public class MinutesController {

    @Autowired
    private HttpServletRequest request; //this is a proxy delegating to the real request object bind to the current thread

    @RequestMapping(value = "/addMinutes")
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise, Model model, HttpSession session) {
        model.addAttribute("controllerHash", this.hashCode());
        model.addAttribute("action", "Add Minutes to goal ");
        Goal goal = (Goal) session.getAttribute(GoalController.CURRENT_GOAL_SESSION_KEY);
        if(goal == null)
            return "redirect:addGoal.html";
        model.addAttribute(GoalController.CURRENT_GOAL_SESSION_KEY, goal);

        if (Objects.equals("GET", request.getMethod())) {
            return "addMinutes";
        } else {
            return "forward:addMoreMinutes.html"; //goto addMoreMinutes action without going back to client
            //return "redirect:addMoreMinutes.html";
        }
    }

    @Resource(name = "exerciseRepository")
    private ExerciseRepository exerciseRepository;

    @RequestMapping(value = "/addMoreMinutes")
    public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise, Model model, HttpSession session, BindingResult bindingResult/*bindingResult is a set of validation errors */) {
        //model.addAttribute("controllerHash", this.hashCode());
        model.addAttribute("action", "Add More Minutes:");
        Goal goal = (Goal) session.getAttribute(GoalController.CURRENT_GOAL_SESSION_KEY);
        if(goal == null)
            return "redirect:addGoal.html";
        model.addAttribute(GoalController.CURRENT_GOAL_SESSION_KEY, goal);

        if (request.getMethod().equals("POST")) {

            exercise.setGoal(goal);

            //we validate this way because @Valid produced a 400 error on this forwarded action method.
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            ValidationUtils.invokeValidator(new SpringValidatorAdapter(validator), exercise, bindingResult);//need to bridge across Bean validator and Spring validator and populate binding results.
            if (!bindingResult.hasErrors()) {
                exerciseService.save(exercise);
                model.addAttribute("actionResult", "Minutes saved.");
            }
        }

        Integer totalMinutes = exerciseRepository.findTotalMinutes(goal.getId());
        model.addAttribute("totalMinutes", totalMinutes);

        return "addMinutes";//view name will be resolved by InternalResourceViewResolver
    }

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Activity> findAllActivities() {
        return exerciseService.findAllActivities();
    }

    @RequestMapping(value = "/bestActivity", method = RequestMethod.GET)
    public
    @ResponseBody
    Activity findBestActivity() {
        return exerciseService.findBestActivity(); //must return a jaxb annotated object to support .xml request.
    }
}
