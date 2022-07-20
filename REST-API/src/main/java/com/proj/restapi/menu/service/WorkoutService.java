package com.proj.restapi.menu.service;

import general.Workout;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutService {

    public static List<Workout> getWorkoutPerUserId(int userId){
        //TODO - get workout for the relevant user
        return Arrays.asList(
                new Workout(1, "Power Hands", 1,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f ),
                new Workout(2, "Power legs", 2,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 20f ),
                new Workout(3, "Pilatis", 3,
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 60f )
        );
    }

    public static Workout getWorkoutForUserByWorkoutId(int userId, int workoutId){
        return new Workout(1, "Power Hands", 1,
                new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f );
    }
}
