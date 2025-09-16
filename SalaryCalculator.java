import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private double salary;
    private List<Employee> directReports = new ArrayList<>();

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void addDirectReport(Employee employee) {
        this.directReports.add(employee);
    }

    public double getSalary() {
        return salary;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }
}

public class SalaryCalculator {
    public double calculateTotalSalary(Employee employee) {
        // Your implementation here
        if(employee.getDirectReports().isEmpty()){
            return employee.getSalary();
        }
        double totalSalary = employee.getSalary();
        for (Employee employeeSalary : employee.getDirectReports()){
            totalSalary += calculateTotalSalary(employeeSalary);
        }
        return totalSalary;
    }

    public static void main(String[] args) {
        Employee ceo = new Employee("CEO", 100000);
        Employee vp1 = new Employee("VP1", 75000);
        Employee vp2 = new Employee("VP2", 80000);
        Employee manager1 = new Employee("Manager1", 60000);
        Employee dev1 = new Employee("Dev1", 50000);
        Employee dev2 = new Employee("Dev2", 55000);

        ceo.addDirectReport(vp1);
        ceo.addDirectReport(vp2);
        vp1.addDirectReport(manager1);
        manager1.addDirectReport(dev1);
        manager1.addDirectReport(dev2);

        SalaryCalculator calculator = new SalaryCalculator();
        double totalSalary = calculator.calculateTotalSalary(ceo);
        System.out.println("Total salary of the organization: " + totalSalary);

        double managerSalary = calculator.calculateTotalSalary(manager1);
        System.out.println("Total salary of Manager1's team: " + managerSalary);
    }
}