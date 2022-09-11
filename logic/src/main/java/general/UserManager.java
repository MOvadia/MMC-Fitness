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


    public synchronized void addUser(User user2) {
        List<User> userList= usersSet.stream().filter(users -> users.getUserId() == user2.getUserId()).collect(Collectors.toList());

        if(userList.size()!=0){
            return;
        }
        usersSet.add(user2);
    }

    public synchronized void removeUser(Integer userId) {
        int userIdToRemove = -1;
        for (int i = 0; i< UserManager.usersSet.size(); i++) {
            if(UserManager.usersSet.get(i).getUserId() == userId){
                userIdToRemove = i;
                break;
            }
        }
        if(userIdToRemove != -1){
            UserManager.usersSet.remove(userIdToRemove);
        }
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
