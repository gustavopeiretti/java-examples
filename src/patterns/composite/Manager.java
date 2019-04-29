package patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private List<Employee> employees = new ArrayList<>();
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public void add(Employee e) {
        if (e != null) {
            this.employees.add(e);
        }
    }

    @Override
    public void remove(Employee e) {
        if (e != null) {
            this.employees.remove(e);
        }
    }

    @Override
    public int calculatePoints() {
        if (this.employees.isEmpty()) {
            return 0;
        }
        return Math.round(this.employees.stream().mapToInt(e -> {
            System.out.println(e);
            return e.calculatePoints();
        }).sum());
    }

    @Override
    public String getName() {
        return this.name;
    }

}
