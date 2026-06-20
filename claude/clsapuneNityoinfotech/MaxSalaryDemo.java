package claude.clsapuneNityoinfotech;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (Rs." + salary + ")";
    }
}

public class MaxSalaryDemo {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Prashant", 80000, "IT"),
                new Employee(2, "Amit", 95000, "IT"),
                new Employee(3, "Riya", 70000, "HR"),
                new Employee(4, "Sneha", 60000, "HR"),
                new Employee(5, "Karan", 110000, "Finance")
        );

        // Department -> Employee with max salary in that department
        Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        result.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get()));
        // Output:
        // HR -> Riya (Rs.70000.0)
        // Finance -> Karan (Rs.110000.0)
        // IT -> Amit (Rs.95000.0)
        
        Map<String, Optional<Employee>> maxSalaryPerDept2 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        
        
        maxSalaryPerDept2.forEach((dept, emp) -> {
            System.out.println(dept + " -> " + emp.get());
        });
        
        
        Map<String, Optional<Double>> maxSalaryPerDept3 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getSalary, 
                                Collectors.maxBy(Double::compareTo))
                ));
        
        Map<String, Double> maxSalaryPerDept4 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,   // key
                        Employee::getSalary,        // value
                        Double::max                 // merge function on key collision
                ));
        
        
        maxSalaryPerDept3.forEach((dept, sal) -> 
        System.out.println(dept + " -> " + sal.get()));

// Version 2
maxSalaryPerDept4.forEach((dept, sal) -> 
        System.out.println(dept + " -> " + sal));
    }
}