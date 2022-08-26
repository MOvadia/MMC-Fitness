package general;

import java.util.*;
import java.util.stream.Collectors;

/*
Adding and retrieving users is synchronized and in that manner - these actions are thread safe
Note that asking if a user exists (isUserExists) does not participate in the synchronization and it is the responsibility
of the user of this class to handle the synchronization of isUserExists with other methods here on it's own
 */
public class UserManager {

    private static List<User> usersSet = null;

    public UserManager() {
        usersSet = new ArrayList<>();
    }


    public synchronized void addUser(User user) {
        usersSet.add(user);
    }

    public synchronized void removeUser(String username) {
        usersSet.remove(username);
    }

    public boolean isUserExists(String username) {
        return usersSet.contains(username);
    }

    public static List<User> getUsersSet() {
        return usersSet;
    }

    public static String getUserNameById(int id)
    {
        User user = usersSet.stream().filter(users -> users.getUserId() == id).collect(Collectors.toList()).get(0);
        return user.getFirstName() + " " + user.getLastName();
    }

    public static String getTypeById(int id)
    {
        User user = usersSet.stream().filter(users -> users.getUserId() == id).collect(Collectors.toList()).get(0);
        return user.getType();
    }
}
