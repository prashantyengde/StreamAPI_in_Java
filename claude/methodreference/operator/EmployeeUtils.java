package claude.methodreference.operator;

class EmployeeUtils {

    // Static Method 1 — Print basic info
    static void printInfo(Employee e) {
        System.out.println("[" + e.id + "] " + e.name + " | " + e.department);
    }

    // Static Method 2 — Print salary with formatting
    static void printSalary(Employee e) {
        System.out.printf("  %-15s → ₹%.0f%n", e.name, e.salary);
    }

    // Static Method 3 — Print only if IT department
    static void printIfIT(Employee e) {
        if (e.department.equals("IT")) {
            System.out.println("  IT Member: " + e.name);
        }
    }

    // Static Method 4 — Print high earners
    static void printHighEarner(Employee e) {
        if (e.salary > 80000) {
            System.out.println("  ★ High Earner: " + e.name + " ₹" + e.salary);
        }
    }
}
