/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

import java.util.Scanner;

/**
 *
 * @author User
 * Admin
■ The only user available at the start
■ Username: admin
■ Password: java
■ Can add, modify and delete other users (including username, password and role)
■ Can change their own username and password
■ Cannot generate reports
 */
public class Admin {
    private String username;
    private String password;

    // Constructor
    public Admin() {
        this.username = "admin";
        this.password = "java";
    }

     // Getters and setters for username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    
    // Menu loop
    //Scanner scanner = new Scanner(System.in);
//    boolean exit = false;
//    while (!exit) {
//        System.out.println("\nMenu:");
//        System.out.println("1. View current staff");
//        System.out.println("2. Add new staff");
//        System.out.println("3. Exit");
//        System.out.println("Enter your choice:");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); 
//
//        switch (choice) {
//            case 1:
//                System.out.println("Current Staff:");
//                // Call the listEmployees method to display current staff
//                company.listEmployees(0); // You can pass any value as parameter for this example
//                break;
//            case 2:
//                // Add new staff
//                System.out.println("Enter employee name:");
//                String name = scanner.nextLine();
//                System.out.println("Enter employee email:");
//                String email = scanner.nextLine();
//                scanner.nextLine(); 
//
//                // Create a new employee and add it to the company
//                Employee newEmployee = new Employee(name, email);
//                company.addNewStaff(newEmployee);
//                System.out.println("New staff added successfully!");
//                break;
//            case 3:
//                System.out.println("Exiting...");
//                exit = true;
//                break;
//            default:
//                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
//        }
//    }
    // Close scanner
    //    scanner.close();
}
