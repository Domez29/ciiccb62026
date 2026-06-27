package Task.PRJMODULE2;

import java.util.HashMap;
import java.util.Map;

public class database {
    // Simulated 'users' table
    private static final Map<String, User> usersTable = new HashMap<>();

    public static void addUser(User user) {
        usersTable.put(user.getId(), user);
    }

    public static User getUser(String id) {
        return usersTable.get(id);
    }

    public static User getUserByNumber(String number) {
        for (User user : usersTable.values()) {
            if (user.getNumber().equals(number)) {
                return user;
            }
        }
        return null;
    }
}
