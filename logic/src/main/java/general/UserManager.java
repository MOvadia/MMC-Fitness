package general;

import java.util.*;

/*
Adding and retrieving users is synchronized and in that manner - these actions are thread safe
Note that asking if a user exists (isUserExists) does not participate in the synchronization and it is the responsibility
of the user of this class to handle the synchronization of isUserExists with other methods here on it's own
 */
public class UserManager {

    private static List<String> usersSet = null;

    public UserManager() {
        usersSet = new ArrayList<>();
    }


    public synchronized void addUser(String username) {
        usersSet.add(username);
    }

    public synchronized void removeUser(String username) {
        usersSet.remove(username);
    }

    public boolean isUserExists(String username) {
        return usersSet.contains(username);
    }

    public static List<String> getUsersSet() {
        return usersSet;
    }
}
