package general;

import java.util.List;
import java.util.Objects;

public class SubscriberToWorkout {
    private Integer userId;
    private Integer workoutId;

    public SubscriberToWorkout() {
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriberToWorkout that = (SubscriberToWorkout) o;
        return Objects.equals(userId, that.userId) && Objects.equals(workoutId, that.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, workoutId);
    }
}

