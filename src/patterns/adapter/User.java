package patterns.adapter;

public class User {

    private int id;
    private String name;
    private double totalAvailable;

    public User(int id, String name, double totalAvailable) {
        this.id = id;
        this.name = name;
        this.totalAvailable = totalAvailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTotalAvailable() {
        return totalAvailable;
    }
}
