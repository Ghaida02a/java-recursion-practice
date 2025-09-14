import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

class Employee {
    private final String name;
    private final double salary;
    private final List<Employee> subordinates;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public double getSalary() {
        return salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String getName() {
        return name;
    }
}

class Organization {
    public double calculateTotalSalary(Employee manager) {
        if (manager.getSubordinates().isEmpty()) {
            return manager.getSalary();
        }
        return calculateTotalSalary(manager.getSubordinates().removeFirst()) + calculateTotalSalary(manager);
    }
}