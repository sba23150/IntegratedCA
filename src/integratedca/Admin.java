/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Tatiana Mota - sba2350
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
    public void displayMenu() throws SQLException {
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
                // Option 1: Add, modify, delete users
                case 1:
                    System.out.println("Type 1 to Add,  2 to modify or 3 to delete other users");
                    int updateUser = scanner.nextInt();
                    System.out.println("Who do you want to update their details? Type 1 for Office, 2 for Lecturer");
                    int updateTypeUser = scanner.nextInt();
                    switch (updateUser) {
                        case 1:
                            switch (updateTypeUser){
                                case 1:
                                    //call method from Office class to add user
                                    Office myOfficeObj = new Office();
                                    myOfficeObj.addUser();
                                    break;
                                case 2:
                                    //call method from Lecturers class to add user
                                    Lecturers myLecturerObj = new Lecturers();
                                    myLecturerObj.addUser();
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please type 1 for Office, 2 for Lecture");
                            }
                            break;
                        case 2:
                            switch (updateTypeUser){
                                case 1:
                                    //call method from Office class to modify user
                                    Office myOfficeObj = new Office();
                                    myOfficeObj.modifyUser();
                                    break;
                                case 2:
                                    //call method from Lecturers class to modify user
                                    Lecturers myLecturerObj = new Lecturers();
                                    myLecturerObj.modifyUser();
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please type 1 for Office, 2 for Lecture");
                            }
                            break;
                        case 3:
                            switch (updateTypeUser){
                                case 1:
                                    //call method from Office class to delete user
                                    Office myOfficeObj = new Office();
                                    myOfficeObj.deleteUser();
                                    break;
                                case 2:
                                    //call method from Lecturers class to delete user
                                    Lecturers myLecturerObj = new Lecturers();
                                    myLecturerObj.deleteUser();
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please type 1 for Office, 2 for Lecture");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please type 1 to Add,  2 to modify or 3 to delete other users");
                            
                    }
                    exitMenu = true;
                    break;

                // Option 2: Change username and password
                case 2:
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
                
                // Option 3: Exit
                case 3:
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
