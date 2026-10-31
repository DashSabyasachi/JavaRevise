package assignment;

import java.util.ArrayList;

public class EmpMgr {

    private ArrayList<Employee> employees;

    public EmpMgr() {
        this.employees = new ArrayList<>();
    }
    
  
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\n===== All Employee Details =====");
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }


    public Employee searchById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }


    public int getEmployeeCount() {
        return employees.size();
    }
}