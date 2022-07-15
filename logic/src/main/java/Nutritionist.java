public class Nutritionist extends Subscriber{
    private enum seniority{};

    public Nutritionist(Integer userId, Integer age, Float height, Float weight, Integer workoutAmount, Float targetFatPercentage, Float targetWeight) {
        super(userId, age, height, weight, workoutAmount, targetFatPercentage, targetWeight);
    }
}
