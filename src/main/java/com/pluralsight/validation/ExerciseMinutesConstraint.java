package com.pluralsight.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Check that an exercise will not cause its goal to have more minutes that its limit.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy={ExerciseMinutesValidator.class})
public @interface ExerciseMinutesConstraint {

    String message() default "{com.pluralsight.validation.exerciseminutes}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
