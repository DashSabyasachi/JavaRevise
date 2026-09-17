package spring_boot;

public class Start {
	public static void main(String[] args) {
		EmployeeRepository repository = new EmployeeRepository();
	
		EmployeeService service = new EmployeeService(repository);
	}

}
