package assignment;

import java.util.ArrayList;

/**
 * EmployeeManager handles all operations on the collection of employees:
 * adding, displaying, and searching. Keeping this separate from Employee
 * (the data model) and from the main class (user I/O) keeps each class
 * focused on a single responsibility.
 */
public class EmpMgr {

    private ArrayList<Employee> employees;

    public EmpMgr() {
        this.employees = new ArrayList<>();
    }

    /**
     * Adds a new employee to the collection.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Displays details of every employee currently stored.
     */
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

    /**
     * Searches for an employee by ID.
     * Returns the Employee if found, otherwise returns null.
     */
    public Employee searchById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    /**
     * Returns the number of employees currently stored.
     */
    public int getEmployeeCount() {
        return employees.size();
    }
}