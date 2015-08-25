package com.pluralsight.model;

import com.pluralsight.validation.ExerciseMinutesConstraint;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@ExerciseMinutesConstraint
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    @Range(min = 1, max = 120)
    private int minutes;

    @NotNull
    @Size(min = 1)
    private String activity;

    @ManyToOne()
    @NotNull
    private Goal goal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
