/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Tatiana Mota - sba23150
 * GitHub: https://github.com/sba23150/IntegratedCA.git
 * Lecturer
■ Can generate a Lecturer Report for themselves
■ Can change their own username and password
 */

public class Lecturers {
    private String username;
    private String password;
    
    // Constructor
    public Lecturers() {
        this.username = "lecturer";
        this.password = "lecturer";
        this.Lecturer = Lecturer;
        this.Role = Role;
        this.TypeClass = TypeClass;
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
    
    //defining variables to read table columns
    String Lecturer;
    String Role;
    String TypeClass;
    
    
    public String getLecturer(){
        return Lecturer;
    }
    
    public String getRole(){
        return Role;
    }
    
    public String getTypeClass(){
        return TypeClass;
    }

    // Method to display menu and handle user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;
        
        while (!exitMenu) {
            System.out.println("\nMenu:");
            System.out.println("1. Generate report.");
            System.out.println("2. Change your own username and password");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Option 1: Generate report as per lecturer name
                    System.out.println("Enter your name to generate your report:");
                    String lecturerName = scanner.nextLine();
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

    ArrayList<String[]> lecturersList = new ArrayList<>();
    
    public void addUser(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter new Lecturer name:");
        String newLecturerName = scanner.nextLine();
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        
        //add new username and password to lecturers list
        String[] addUser = {newLecturerName, newUsername, newPassword};
        lecturersList.add(addUser);
        
        System.out.println("New Lecturer user added successfully!");
        scanner.close();
    }
    
    public void modifyUser(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Lecturer name to modify:");
        String lecturerName = scanner.nextLine();
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        
        String[] addUser = {lecturerName, newUsername, newPassword};
        
        //first we need to find where is the lecturer that the user wants to modify
        // Find the index of an item in the ArrayList
        int index = lecturersList.indexOf(lecturerName);

        // Check if the item exists in the ArrayList
        if (index != -1) {
            //modiy new username and password to lecturers list
            lecturersList.set(index,addUser);
        } else {
            System.out.println(lecturerName+" not found in the list.");
        }

        System.out.println("New Lecturer user modified successfully!");
        scanner.close();
    }
    
    public void deleteUser(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Lecturer name to delete:");
        String lecturerName = scanner.nextLine();
        
        //first we need to find where is the lecturer that the user wants to modify
        // Find the index of an item in the ArrayList
        int index = lecturersList.indexOf(lecturerName);

        // Check if the item exists in the ArrayList
        if (index != -1) {
            //modiy new username and password to lecturers list
            lecturersList.remove(index);
        } else {
            System.out.println(lecturerName+" not found in the list.");
        }

        System.out.println("Lecturer udeleted successfully!");
        scanner.close();
    }
}
