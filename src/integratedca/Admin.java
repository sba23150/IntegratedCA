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
    public String username;
    public String password;

    // Constructor
    public Admin() {
        this.username = "admin";
        this.password = "java";
    }

    // Getters and setters for username and password
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Method to display menu and handle user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;
        
        while (!exitMenu) {
            System.out.println("\nMenu:");
            System.out.println("1. Add, modify and delete other users");
            System.out.println("2. Change your own username and password");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Option 1: Add, modify, delete users
                    System.out.println("Add, modify and delete other users");
                    // Add code here
                    exitMenu = true;
                    break;
                case 2:
                    // Option 2: Change username and password
                    System.out.println("Enter new username:");
                    String newUsername = scanner.nextLine();
                    System.out.println("Enter new password:");
                    String newPassword = scanner.nextLine();

                    // Call methods to set new username and password
                    setUsername(newUsername); 
                    setPassword(newPassword); 

                    System.out.println("Changed user and password successfully!");
                    exitMenu = true;
                    break;
                case 3:
                    // Option 3: Exit
                    System.out.println("Exiting...");
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
            }
        }
        
        // Close scanner after loop
        scanner.close();
    }
}
