package claude.streamapi.employee;


class Employee {
	int id;
	String name, department, gender, city;
	double salary;
	int age;

	Employee(int id, String name, String department, String gender, double salary, int age, String city) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
		this.age = age;
		this.city = city;
	}

	public String toString() {
		return String.format("[%d] %-15s | %-10s | %-6s | ₹%-7.0f | Age: %d | %s", id, name, department, gender, salary,
				age, city);
	}
}
