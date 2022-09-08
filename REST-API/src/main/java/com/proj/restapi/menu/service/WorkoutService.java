package com.proj.restapi.menu.service;

import com.proj.restapi.actionresult.ActionResult;
import general.SubscriberToMenu;
import general.SubscriberToExercise;
import general.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class WorkoutService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Workout> getWorkoutPerUserId(int userId){
        String sqlExersice = "SELECT * FROM [SubscriberToExercise] where userId = " + userId;
        List<SubscriberToExercise> exercises = jdbcTemplate.query(sqlExersice, BeanPropertyRowMapper.newInstance(SubscriberToExercise.class));
        List<Workout> workouts = new ArrayList<>();
        Workout workout;
        for (SubscriberToExercise stoW: exercises) {
            String sqlWorkouts = "  select w.workoutId, w.name, w.createdBy, w.focus from Workout w, Exercise e" +
                    " where w.workoutId = e.workoutId " +
                    " and e.exercise = '" + stoW.getExerciseName() + "'";
            try {
                workout = jdbcTemplate.queryForObject(sqlWorkouts, BeanPropertyRowMapper.newInstance(Workout.class));
                workouts.add(workout);

            } catch (EmptyResultDataAccessException e) {
                workout = null;
            }
        }
        return workouts;
    }


    public ActionResult<String> addWorkout(Workout workout){
        try {
            //Connect to DB and update workouts table with the new workout
            return ActionResult.successMessage("The workout updated successfully");
        } catch (Exception e) {
            return ActionResult.failed("Failed to update the workout");
        }
    }

    public ActionResult<String> deleteWorkout(Integer workoutId){
        try {
            //Connect to DB and delete the specific workout from workouts table
            return ActionResult.successMessage("The workout deleted successfully");
        } catch (Exception e) {
            return ActionResult.failed("Failed to delete the workout");
        }
    }
}
