package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT sum(e.minutes) FROM Exercise e WHERE e.goal.id = :goalId")
    Integer findTotalMinutes(@Param("goalId") Long goalId);
}
