package claude.methodreference.operator;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}



/*
 * ```
 * 
 * ---
 * 
 * ### Output ``` 1. Print All Employees: [1] Aarav Sharma | IT [2] Priya Mehta
 * | HR [3] Rohit Verma | Finance [4] Sneha Patil | IT [5] Karan Singh | IT [6]
 * Anjali Rao | Marketing [7] Vikram Nair | Finance [8] Pooja Joshi | HR [9]
 * Amit Kulkarni | Marketing [10] Divya Iyer | IT
 * 
 * 2. Print Salaries: Aarav Sharma → ₹85000 Priya Mehta → ₹62000 Rohit Verma →
 * ₹91000 Sneha Patil → ₹78000 Karan Singh → ₹95000 Anjali Rao → ₹55000 Vikram
 * Nair → ₹110000 Pooja Joshi → ₹48000 Amit Kulkarni → ₹67000 Divya Iyer →
 * ₹88000
 * 
 * 3. Print IT Employees Only: IT Member: Aarav Sharma IT Member: Sneha Patil IT
 * Member: Karan Singh IT Member: Divya Iyer
 * 
 * 4. Print High Earners (> ₹80,000): ★ High Earner: Aarav Sharma ₹85000 ★ High
 * Earner: Rohit Verma ₹91000 ★ High Earner: Karan Singh ₹95000 ★ High Earner:
 * Vikram Nair ₹110000 ★ High Earner: Divya Iyer ₹88000
 */