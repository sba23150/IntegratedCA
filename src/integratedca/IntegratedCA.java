/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integratedca;

import java.util.Scanner;

/**
 *
 * @author Tatiana Mota - sba23150
 * GitHub: https://github.com/sba23150/IntegratedCA.git
 */
public class IntegratedCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Call DB Connection
//        try {
//            DBConnector db = new DBConnector();
//            db.getStudents();
//            //create database 'CA2'
//            //db.createDB();
//        } catch (SQLException ex) {
//            Logger.getLogger(IntegratedCA.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        // Console input scanner to read user input
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();
        Office office = new Office();
        Lecturers lecturer = new Lecturers();
        
        // Login loop
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Enter username:");
            String usernameInput = scanner.nextLine();
            System.out.println("Enter password:");
            String passwordInput = scanner.nextLine();

            // Check if the entered username and password match the Admin's credentials
            if (usernameInput.equals(admin.getUsername()) && passwordInput.equals(admin.getPassword())) {
                System.out.println("Login successful!");
                // call the Admin class
                admin.displayMenu();
                loggedIn = true;
            } 
            // Check if the entered username and password match the Office's credentials 
            else if (usernameInput.equals(office.getUsername()) && passwordInput.equals(office.getPassword())) {
                System.out.println("Login successful!");
                // call the Office class
                office.displayMenu();
                loggedIn = true;
            } 
            // Check if the entered username and password match the Lecturer's credentials 
            else if (usernameInput.equals(lecturer.getUsername()) && passwordInput.equals(lecturer.getPassword())) {
                System.out.println("Login successful!");
                // call the Lecturer class
                Lecturers.displayMenu();
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
        // Close scanner
        scanner.close();
    }
    
}