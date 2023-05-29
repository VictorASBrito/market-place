import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private Map<Integer, User> users;
    private int nextId;

    public UserManager() {
        users = new HashMap<>();
        nextId = 1;
    }

    public int addUser(String name, int age, String role, String password) {
        User user = new User(nextId, name, password, age, role);
        users.put(nextId, user);
        nextId++;
        return user.getId();
    }

    public boolean removeUser(int id) {
        return users.remove(id) != null;
    }

    public boolean changeUserRole(int id, String newRole) {
        User user = users.get(id);
        if (user != null) {
            user.setRole(newRole);
            return true;
        }
        return false;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
