package general;

public class Nutritionist extends User{
    private enum seniority{};

    public Nutritionist(Integer userId, String firstName, String lastName, String phoneNumber, String email) {
        super(userId, firstName, lastName, phoneNumber, email);
    }
}
