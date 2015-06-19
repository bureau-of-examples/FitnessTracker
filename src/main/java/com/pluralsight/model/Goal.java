package com.pluralsight.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goals")
@NamedQueries({
        @NamedQuery(name = Goal.FIND_GOAL_REPORTS, query = "SELECT new com.pluralsight.model.GoalReport(g.minutes,e.minutes, e.activity) FROM Goal g, Exercise e WHERE g.id = e.goal.id")
})
public class Goal {

    public static final String FIND_GOAL_REPORTS = "find_goal_reports";

    @Id
    @GeneratedValue
    private Long id;

    @Range(min = 1, max = 130)
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL/*, fetch = FetchType.EAGER*/)
    private List<Exercise> exercises = new ArrayList<Exercise>();

    public Goal(){
       setMinutes(10);
    }

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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
