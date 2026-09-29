package assignment;

import java.util.Scanner;


public class EmpMgmtSys {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpMgr manager = new EmpMgr();

        
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

       
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            manager.addEmployee(new Employee(id, name, salary));
        }

       
        manager.displayAllEmployees();

       
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