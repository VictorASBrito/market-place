
public class User {
    private final int id;
    private String name;
    private int age;
    private String role;
    private final String password;

    public User(int id, String name, String password, int age, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

