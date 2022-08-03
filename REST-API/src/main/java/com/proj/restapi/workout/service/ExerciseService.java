package com.proj.restapi.workout.service;

import general.Exercise;
import general.Subscriber;
import general.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Exercise> getExercisesByWorkoutId(int workoutId) {
        String sqlExerciseTable = "SELECT * FROM [Exercise] where workoutId=" + workoutId;
        List<Exercise> exercises = jdbcTemplate.query(sqlExerciseTable,
                BeanPropertyRowMapper.newInstance(Exercise.class));

        return exercises;
    }
}
