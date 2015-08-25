package com.pluralsight.model;


public class GoalReport {

    private Long goalId;
    private String description;
    private Integer goalMinutes;
    private Long exerciseMinutes;
    private Long numberOfActivities;

    public GoalReport(long goalId, String description, Integer goalMinutes, Long exerciseMinutes, Long numberOfActivities) {
        this.goalId = goalId;
        this.description = description;
        this.goalMinutes = goalMinutes;
        this.exerciseMinutes = exerciseMinutes;
        this.numberOfActivities = numberOfActivities;

        if(this.exerciseMinutes == null)
            this.exerciseMinutes = 0L;

        if(this.numberOfActivities == null)
            this.numberOfActivities = 0L;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGoalMinutes() {
        return goalMinutes;
    }

    public void setGoalMinutes(Integer goalMinutes) {
        this.goalMinutes = goalMinutes;
    }

    public Long getExerciseMinutes() {
        return exerciseMinutes;
    }

    public void setExerciseMinutes(Long exerciseMinutes) {
        this.exerciseMinutes = exerciseMinutes;
    }

    public Long getNumberOfActivities() {
        return numberOfActivities;
    }

    public void setNumberOfActivities(Long numberOfActivities) {
        this.numberOfActivities = numberOfActivities;
    }
}
