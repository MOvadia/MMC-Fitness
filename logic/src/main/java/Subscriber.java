import java.util.Objects;

public class Subscriber {
    private Integer userId;
    private Integer age;
    private Float height;
    private Float weight;
    private enum dietaryLimitations{};
    private enum physicalLimitations{};
    private enum gender {female, male};
    private Integer workoutAmount;
    private Float targetFatPercentage;
    private Float targetWeight;

    public Subscriber(Integer userId, Integer age, Float height, Float weight, Integer workoutAmount, Float targetFatPercentage, Float targetWeight) {
        this.userId = userId;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.workoutAmount = workoutAmount;
        this.targetFatPercentage = targetFatPercentage;
        this.targetWeight = targetWeight;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getWorkoutAmount() {
        return workoutAmount;
    }

    public void setWorkoutAmount(Integer workoutAmount) {
        this.workoutAmount = workoutAmount;
    }

    public Float getTargetFatPercentage() {
        return targetFatPercentage;
    }

    public void setTargetFatPercentage(Float targetFatPercentage) {
        this.targetFatPercentage = targetFatPercentage;
    }

    public Float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Float targetWeight) {
        this.targetWeight = targetWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return userId.equals(that.userId) && age.equals(that.age) && height.equals(that.height) && weight.equals(that.weight) && workoutAmount.equals(that.workoutAmount) && targetFatPercentage.equals(that.targetFatPercentage) && targetWeight.equals(that.targetWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, age, height, weight, workoutAmount, targetFatPercentage, targetWeight);
    }
}
