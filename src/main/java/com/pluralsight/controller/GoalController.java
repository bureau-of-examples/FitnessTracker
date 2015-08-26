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
    private GoalService goalService;

    public static final String CURRENT_GOAL_SESSION_KEY = "goal";
    private static final String LAST_GOAL_SESSION_KEY = "!goal";

    @RequestMapping(value = "/updateGoal", method = {RequestMethod.GET})
    public String updateGoal(Model model, @RequestParam(value = "create", required = false) Boolean create, HttpSession session) {
        Goal goal;
        if (Boolean.TRUE.equals(create)) {
            goal = new Goal();
        } else {
            goal = (Goal) session.getAttribute(CURRENT_GOAL_SESSION_KEY);
            //cannot update not saved.
            if (goal == null || goal.getId() == null) {
                //find the goal to update.
                goal = (Goal)session.getAttribute(LAST_GOAL_SESSION_KEY);
                if(goal == null)
                    return "redirect:addGoal.html";
            }
        }
        model.addAttribute(CURRENT_GOAL_SESSION_KEY, goal);
        return "addGoal";
    }

    @RequestMapping(value = "/addGoal", method = {RequestMethod.GET})
    public String addGoal(Model model) {

        return "forward:updateGoal.html?create=true";
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN') and hasPermission(#goal, 'create')")
    @RequestMapping(value = {"/addGoal", "/updateGoal"}, method = RequestMethod.POST)
    public String addGoal(@Valid @ModelAttribute(CURRENT_GOAL_SESSION_KEY) Goal goal, BindingResult bindingResult, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            if ("Reserved".equals(goal.getDescription()))
                throw new RuntimeException("Goal name cannot be 'Reserved.'");

            boolean updating = goal.getId() != null;
            goalService.save(goal);
            session.setAttribute(LAST_GOAL_SESSION_KEY, goal);

            if (updating)
                return "redirect:addMoreMinutes.html";
            return "redirect:addMinutes.html";
        }

        return "addGoal";
    }

    @RequestMapping(value = "/setGoal", method = RequestMethod.POST)
    public
    @ResponseBody
    String setGoal(@RequestParam(value = "goalId", required = true) long goalId, Model model) {

        Goal goal = goalService.getGoal(goalId);
        if (goal == null)
            throw new RuntimeException("Cannot find goal " + goalId);

        model.addAttribute(CURRENT_GOAL_SESSION_KEY, goal);
        model.addAttribute(LAST_GOAL_SESSION_KEY, goal);
        return "success";

    }

    @RequestMapping(value = "/getGoals", method = RequestMethod.GET)
    public String getGoals(Model model) {
        List<Goal> goals = goalService.getAllGoals();
        model.addAttribute("goals", goals);
        return "getGoals";

    }

    @RequestMapping(value = "/getGoalReports", method = RequestMethod.GET)
    public String getGoalReports(Model model) {
        List<GoalReport> goalReports = goalService.findAllGoalReports();
        model.addAttribute("goalReports", goalReports);
        return "getGoalReports";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(" -", true));
    }


}
