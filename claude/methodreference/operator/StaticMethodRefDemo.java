package claude.methodreference.operator;

import java.util.Arrays;
import java.util.List;

public class StaticMethodRefDemo {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(1, "Aarav Sharma",  "IT",        85000),
            new Employee(2, "Priya Mehta",   "HR",        62000),
            new Employee(3, "Rohit Verma",   "Finance",   91000),
            new Employee(4, "Sneha Patil",   "IT",        78000),
            new Employee(5, "Karan Singh",   "IT",        95000),
            new Employee(6, "Anjali Rao",    "Marketing", 55000),
            new Employee(7, "Vikram Nair",   "Finance",   110000),
            new Employee(8, "Pooja Joshi",   "HR",        48000),
            new Employee(9, "Amit Kulkarni", "Marketing", 67000),
            new Employee(10,"Divya Iyer",    "IT",        88000)
        );

        // Using Static Method Reference — EmployeeUtils::printInfo
        System.out.println("1. Print All Employees:");
        employees.stream()
                 .forEach(EmployeeUtils::printInfo);

        // Using Static Method Reference — EmployeeUtils::printSalary
        System.out.println("\n2. Print Salaries:");
        employees.stream()
                 .forEach(EmployeeUtils::printSalary);

        // Using Static Method Reference — EmployeeUtils::printIfIT
        System.out.println("\n3. Print IT Employees Only:");
        employees.stream()
                 .forEach(EmployeeUtils::printIfIT);

        // Using Static Method Reference — EmployeeUtils::printHighEarner
        System.out.println("\n4. Print High Earners (> ₹80,000):");
        employees.stream()
                 .forEach(EmployeeUtils::printHighEarner);
    }
}