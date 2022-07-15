import java.util.Objects;

public class SubscriberToWorkout {
    private Integer userId;
    private Integer workoutId;

    public SubscriberToWorkout(Integer userId, Integer workoutId) {
        this.userId = userId;
        this.workoutId = workoutId;
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
        return userId.equals(that.userId) && workoutId.equals(that.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, workoutId);
    }
}
