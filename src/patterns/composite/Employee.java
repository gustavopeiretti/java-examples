package patterns.composite;

import java.util.List;

public interface Employee {

    String getName();

    void add(Employee e);

    void remove(Employee e);

    List<Employee> getEmployees();

    int calculatePoints();

}
