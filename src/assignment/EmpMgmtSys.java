package assignment;

import java.util.Scanner;

/**
 * Entry point of the application.
 * Responsible only for taking input from the user and displaying output.
 * All employee data handling is delegated to EmployeeManager.
 */
public class EmpMgmtSys {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpMgr manager = new EmpMgr();

        // Take number of employees
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        // Take employee details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            manager.addEmployee(new Employee(id, name, salary));
        }

        // Display all employees
        manager.displayAllEmployees();

        // Search employee by ID
        System.out.print("\nEnter Employee ID to search: ");
        int searchId = sc.nextInt();

        Employee found = manager.searchById(searchId);

        if (found != null) {
            System.out.println("\n===== Employee Found =====");
            found.displayEmployee();
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        sc.close();
    }
}