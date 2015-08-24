package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

import java.util.List;


public interface GoalService {

    Goal save(Goal goal);

    Goal getGoal(long goalId);

    List<Goal> getAllGoals();

    List<GoalReport> findAllGoalReports();
}
