package com.pluralsight.controller;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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

    @RequestMapping(value = "/addGoal", method = {RequestMethod.GET})
    public String addGoal(Model model){
        Goal goal = (Goal)session.getAttribute("goal");
        if(goal == null){
            goal = new Goal();
        }
        model.addAttribute("goal", goal);
        return "addGoal";
    }

    @RequestMapping(value = "/addGoal", method = RequestMethod.POST)
    public String addGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            goalService.save(goal);
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


}
