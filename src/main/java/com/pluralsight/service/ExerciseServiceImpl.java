package com.pluralsight.service;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    List<Activity> activities = Arrays.asList(new Activity("Run"), new Activity("Swim"), new Activity("Bike"));

    public List<Activity> findAllActivities(){
        return activities;
    }

    public Activity findBestActivity(){
        if(activities.size() == 0)
            return null;
        return activities.get(0);
    }

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Transactional
    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }
}
