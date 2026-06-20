package claude.streamapi.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(1, "Aarav Sharma", "IT", "Male", 85000, 29, "Pune"),
				new Employee(2, "Priya Mehta", "HR", "Female", 62000, 34, "Mumbai"),
				new Employee(3, "Rohit Verma", "Finance", "Male", 91000, 41, "Delhi"),
				new Employee(4, "Sneha Patil", "IT", "Female", 78000, 27, "Pune"),
				new Employee(5, "Karan Singh", "IT", "Male", 95000, 36, "Bangalore"),
				new Employee(6, "Anjali Rao", "Marketing", "Female", 55000, 30, "Hyderabad"),
				new Employee(7, "Vikram Nair", "Finance", "Male", 110000, 45, "Delhi"),
				new Employee(8, "Pooja Joshi", "HR", "Female", 48000, 25, "Mumbai"),
				new Employee(9, "Amit Kulkarni", "Marketing", "Male", 67000, 38, "Pune"),
				new Employee(10, "Divya Iyer", "IT", "Female", 88000, 32, "Bangalore"));

		// 1. FILTER — IT Department only
		System.out.println("1. IT Department Employees:");
		employees.stream().filter(e -> e.department.equals("IT")).forEach(System.out::println);

		// 2. MAP — Extract all names
		System.out.println("\n2. All Employee Names:");
		employees.stream().map(e -> e.name).forEach(System.out::println);

		// 3. SORTED — By salary descending
		System.out.println("\n3. Sorted by Salary (High → Low):");
		employees.stream().sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
				.forEach(e -> System.out.printf("  %-15s ₹%.0f%n", e.name, e.salary));

		// 4. REDUCE — Total salary
		System.out.println("\n4. Total Salary:");
		double total = employees.stream().mapToDouble(e -> e.salary).sum();
		System.out.printf("  ₹%.0f%n", total);

		// 5. AVERAGE — Avg salary
		System.out.println("\n5. Average Salary:");
		employees.stream().mapToDouble(e -> e.salary).average().ifPresent(avg -> System.out.printf("  ₹%.2f%n", avg));

		// 6. GROUP BY — Department
		System.out.println("\n6. Grouped by Department:");
		employees.stream().collect(Collectors.groupingBy(e -> e.department)).forEach((dept, emps) -> {
			System.out.println("  [" + dept + "]");
			emps.forEach(e -> System.out.println("     → " + e.name));
		});

		// 7. COUNT — Per department
		System.out.println("\n7. Count per Department:");
		employees.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.counting()))
				.forEach((dept, count) -> System.out.printf("  %-12s: %d%n", dept, count));

		// 8. FILTER + MAP — High earners (> ₹80,000)
		System.out.println("\n8. Employees with Salary > ₹80,000:");
		employees.stream().filter(e -> e.salary > 80000).map(e -> e.name).forEach(System.out::println);

		// 9. MIN / MAX — Salary
		System.out.println("\n9. Min / Max Salary:");
		employees.stream().min(Comparator.comparingDouble(e -> e.salary))
				.ifPresent(e -> System.out.printf("  Lowest : %s ₹%.0f%n", e.name, e.salary));
		employees.stream().max(Comparator.comparingDouble(e -> e.salary))
				.ifPresent(e -> System.out.printf("  Highest: %s ₹%.0f%n", e.name, e.salary));

		// 10. PARTITION — Male vs Female
		System.out.println("\n10. Partitioned by Gender:");
		Map<Boolean, List<Employee>> partition = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.gender.equals("Male")));
		System.out.println(
				"  MALE:   " + partition.get(true).stream().map(e -> e.name).collect(Collectors.joining(", ")));
		System.out.println(
				"  FEMALE: " + partition.get(false).stream().map(e -> e.name).collect(Collectors.joining(", ")));

		// 11. anyMatch / allMatch / noneMatch
		System.out.println("\n11. Match Operations:");
		System.out.println("  Any salary > ₹1,00,000 ? " + employees.stream().anyMatch(e -> e.salary > 100000));
		System.out.println("  All salary > ₹40,000   ? " + employees.stream().allMatch(e -> e.salary > 40000));
		System.out.println("  None salary < ₹20,000  ? " + employees.stream().noneMatch(e -> e.salary < 20000));

		// 12. COLLECT TO MAP — ID → Name
		System.out.println("\n12. ID → Name Map:");
		employees.stream().collect(Collectors.toMap(e -> e.id, e -> e.name))
				.forEach((id, name) -> System.out.printf("  %d → %s%n", id, name));

		// 13. JOINING — All names in one line
		System.out.println("\n13. All Names Joined:");
		String joined = employees.stream().map(e -> e.name).collect(Collectors.joining(" | "));
		System.out.println("  " + joined);
          
		// 14. DISTINCT CITIES
		System.out.println("\n14. Distinct Cities:");
		employees.stream().map(e -> e.city).distinct().forEach(city -> System.out.println("  " + city));

		// 15. LIMIT & SKIP — Pagination
		System.out.println("\n15. Page 2 (skip 5, limit 5):");
		employees.stream().skip(5).limit(5).forEach(System.out::println);
		
		employees.stream().map(e->e.name).forEach(System.out::println);
	}
}