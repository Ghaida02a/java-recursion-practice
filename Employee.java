import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

class Employee {
    private final String name;
    private final double salary;
    private final List<Employee> subordinates;
//
//    public static void main(String[] args) {
//        // Create employees
//        Employee manager = new Employee("Alice", 10);
//        Employee emp1 = new Employee("Bob", 20);
//        Employee emp2 = new Employee("Charlie", 30);
//        Employee emp3 = new Employee("Diana", 40);
//        // Build hierarchy
//        manager.addSubordinate(emp1);
//        manager.addSubordinate(emp2);
//        manager.addSubordinate(emp3);
//        // Calculate total salary
//        Organization org = new Organization();
//        double total = org.calculateTotalSalary(manager);
//        System.out.println("Total salary for " + manager.getName() + " and her team: " + total);
//    }

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
//        double totalSalary = 0.0;
//        Stack<Employee> stack = new Stack<>();
//        stack.push(manager);
//
//        while (!stack.isEmpty()) {
//            Employee current = stack.pop();
//            totalSalary += current.getSalary();
//            for (Employee subordinate : current.getSubordinates()) {
//                stack.push(subordinate);
//            }
//        }
//        return totalSalary;
        if (manager.getSubordinates().isEmpty()) {
            return manager.getSalary();
        }
        return calculateTotalSalary(manager.getSubordinates().removeFirst()) + calculateTotalSalary(manager);
    }
}