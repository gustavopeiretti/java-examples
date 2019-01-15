package j8.optional;

import java.util.Optional;

class User {

    public static final User EMPTY_USER = new User("EMPTY_USER");

    private String name;
    private int age;
    private String email;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getOptionalEmail() {
        return Optional.ofNullable(email);
    }
}
