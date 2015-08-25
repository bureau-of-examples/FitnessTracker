package com.pluralsight.validation;

import com.pluralsight.model.Exercise;
import com.pluralsight.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ExerciseMinutesValidator implements ConstraintValidator<ExerciseMinutesConstraint, Exercise> {

    /*
    * Injection is done when Spring LocalValidatorFactoryBean instantiates this instance.
    */
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public void initialize(ExerciseMinutesConstraint constraintAnnotation) {
       System.out.println("Initializing ExerciseMinutesValidator.");
    }

    @Override
    public boolean isValid(Exercise value, ConstraintValidatorContext context) {
        if(value != null && value.getGoal() != null){
            Long goalId = value.getGoal().getId();
            if(goalId != null && goalId > 0){
                Integer totalMinutes = exerciseRepository.findTotalMinutes(goalId);
                if(totalMinutes == null)
                    totalMinutes = 0;
                if(totalMinutes + value.getMinutes() > value.getGoal().getMinutes())
                    return false;
            }
        }
        return true;
    }
}
