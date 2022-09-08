package general;

import java.util.List;
import java.util.Objects;

public class SubscriberToExercise {
    private Integer userId;
    private String exerciseName;

    public SubscriberToExercise() {
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriberToExercise that = (SubscriberToExercise) o;
        return Objects.equals(userId, that.userId) && Objects.equals(exerciseName, that.exerciseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, exerciseName);
    }
}

