package com.proj.restapi.menu.service;

import com.proj.restapi.actionresult.ActionResult;
import general.Workout;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutService {

    public static List<Workout> getWorkoutPerUserId(int userId){
        //TODO - get workout for the relevant user
        return Arrays.asList(
                new Workout(1, "Power Hands", "May Ovadia",
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f ),
                new Workout(2, "Power legs", "May Tzadoky",
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 20f ),
                new Workout(3, "Pilatis", "chen Shitrit",
                        new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 60f )
        );
    }

    public static Workout getWorkoutForUserByWorkoutId(int userId, int workoutId){
        return new Workout(1, "Power Hands", "May Ovadia",
                new Timestamp(System.currentTimeMillis()), "This ...", "URL...", 40f );
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
