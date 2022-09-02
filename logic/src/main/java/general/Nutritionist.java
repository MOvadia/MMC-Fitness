package general;

public class Nutritionist extends User{
    private int seniority;

    public Nutritionist() {
    }

    public Nutritionist(Integer userId, String firstName, String lastName, String phoneNumber, String email) {
        super(userId, firstName, lastName, phoneNumber, email);
    }

    public Nutritionist(User u, Nutritionist n) {
        super(u.getUserId(),u.getFirstName(),u.getLastName(),u.getPhoneNumber(),u.getEmail());
    }
}
