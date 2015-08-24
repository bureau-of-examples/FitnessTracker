package com.pluralsight.controller;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("goal")
public class GoalController {

    @Autowired
    private HttpSession session;

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "/updateGoal", method = {RequestMethod.GET})
    public String updateGoal(Model model, @RequestParam(value = "create", required = false) Boolean create){
        Goal goal = (Goal)session.getAttribute("goal");
        if(goal == null || Boolean.TRUE.equals(create)){
            goal = new Goal();
        }
        model.addAttribute("goal", goal);
        return "addGoal";
    }

    @RequestMapping(value = "/addGoal", method = {RequestMethod.GET})
    public String addGoal(Model model){

        return "forward:updateGoal.html?create=true";
    }

    @RequestMapping(value = {"/addGoal", "/updateGoal"}, method = RequestMethod.POST)
    public String addGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            if("Reserved".equals(goal.getDescription()))
                throw new RuntimeException("Goal name cannot be 'Reserved.'");

            boolean updating = goal.getId() != null;
            goalService.save(goal);

            if(updating)
                return "redirect:addMoreMinutes.html";
            return "redirect:addMinutes.html";
        }

        return "addGoal";
    }

    @RequestMapping(value = "/getGoals", method = RequestMethod.GET)
    public String getGoals(Model model){
        List<Goal> goals = goalService.getAllGoals();
        model.addAttribute("goals", goals);
        return "getGoals";

    }

    @RequestMapping(value = "/getGoalReports", method = RequestMethod.GET)
    public String getGoalReports(Model model){
        List<GoalReport> goalReports = goalService.findAllGoalReports();
        model.addAttribute("goalReports", goalReports);
        return "getGoalReports";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(" -", true));
    }



}
