package general;

public class Trainer extends User{

    private enum specialty{};
    private enum seniority{};

    public Trainer() {
    }

    public Trainer(Integer userId, String firstName, String lastName, String phoneNumber, String email) {
        super(userId, firstName, lastName, phoneNumber, email, "Trainer");
    }


    public Trainer(User u, Trainer t) {
        super(u.getUserId(),u.getFirstName(),u.getLastName(),u.getPhoneNumber(),u.getEmail());
    }




}
