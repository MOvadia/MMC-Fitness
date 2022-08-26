package general;

import java.util.Objects;

public class Subscriber extends User {
    private Integer age;
    private Float height;
    private Float weight;
    private enum dietaryLimitations{};
    private enum physicalLimitations{};
    private enum gender {female, male};
    private Integer workoutAmount;
    private Float targetFatPercentage;
    private Float targetWeight;
    private float BMI;

    public Subscriber() {
    }

    public Subscriber(Integer userId, String firstName, String lastName, String phoneNumber, String email, Integer age, Float height,
                      Float weight, Integer workoutAmount, Float targetFatPercentage, Float targetWeight, float BMI) {
        super(userId, firstName, lastName, phoneNumber, email);
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.workoutAmount = workoutAmount;
        this.targetFatPercentage = targetFatPercentage;
        this.targetWeight = targetWeight;
        this.BMI = BMI;
    }

    public Subscriber(User u,Subscriber s){
        super(u.getUserId(),u.getFirstName(),u.getLastName(),u.getPhoneNumber(),u.getEmail());
        this.age = s.getAge();
        this.height = s.getHeight();
        this.weight = s.getWeight();
        this.workoutAmount = s.getWorkoutAmount();
        this.targetFatPercentage = s.getTargetFatPercentage();
        this.targetWeight = s.getTargetWeight();
        this.BMI =s.getBMI();
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


    public float getBMI() {
        return BMI;
    }

    public void setBMI(float BMI) {
        this.BMI = BMI;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(age, that.age) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(workoutAmount, that.workoutAmount) && Objects.equals(targetFatPercentage, that.targetFatPercentage) && Objects.equals(targetWeight, that.targetWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, height, weight, workoutAmount, targetFatPercentage, targetWeight);
    }

    
}
