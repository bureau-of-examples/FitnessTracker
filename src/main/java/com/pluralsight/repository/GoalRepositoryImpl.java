package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext(name = "ft_unit")
    private EntityManager entityManager;

    public Goal save(Goal goal) {
        if(goal.getId() == null){
            entityManager.persist(goal);
            entityManager.flush();
        } else {
            goal = entityManager.merge(goal);
        }

        return goal;
    }

    @SuppressWarnings("unchecked")
    public List<Goal> loadAll() {
        Query query = entityManager.createQuery("SELECT g FROM Goal g");
        return query.getResultList();
    }

    public List<GoalReport> findAllGoalReports() {
        //Query query = entityManager.createQuery("SELECT new com.pluralsight.model.GoalReport(g.minutes,e.minutes, e.activity) FROM Goal g, Exercise e WHERE g.id = e.goal.id");
        TypedQuery<GoalReport> query = entityManager.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
        return query.getResultList();
    }

    @Override
    public Goal get(long goalId){
        return entityManager.find(Goal.class, goalId);
    }
}
