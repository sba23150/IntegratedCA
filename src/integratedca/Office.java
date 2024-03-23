package integratedca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 * Office
■ Can generate all types of reports
■ Can change their own username and password
 */
public class Office {
    private String username;
    private String password;

    // Constructor
    public Office() {
        this.username = "office";
        this.password = "office";
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
            System.out.println("1. Generate reports");
            System.out.println("2. Change your own username and password");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Option 1: Generate reports
                    // Call report method
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
    
    ArrayList<String[]> officeStaffList = new ArrayList<>();
    
    public void addUser(String username, String password){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter new Office staff name:");
        String newOfficeStaffName = scanner.nextLine();
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        
        //add new username and password to office staff list
        String[] addUser = {newOfficeStaffName, newUsername, newPassword};
        officeStaffList.add(addUser);
        
        System.out.println("New Office staff user added successfully!");
        scanner.close();
    }
    
    public void modifyUser(String username, String password){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Office staff name to modify:");
        String OfficeStaffName = scanner.nextLine();
        System.out.println("Enter new username:");
        String newUsername = scanner.nextLine();
        System.out.println("Enter new password:");
        String newPassword = scanner.nextLine();
        
        String[] addUser = {OfficeStaffName, newUsername, newPassword};
        
        //first we need to find where is the office staff that the user wants to modify
        // Find the index of an item in the ArrayList
        int index = officeStaffList.indexOf(OfficeStaffName);

        // Check if the item exists in the ArrayList
        if (index != -1) {
            //modiy new username and password to office staff list
            officeStaffList.set(index,addUser);
        } else {
            System.out.println(OfficeStaffName + " not found in the list.");
        }

        System.out.println("New Office staff user modified successfully!");
        scanner.close();
    }
    
    public void deleteUser(String username, String password){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter office staff name to delete:");
        String officeStaffName = scanner.nextLine();
        
        //first we need to find where is the lecturer that the user wants to modify
        // Find the index of an item in the ArrayList
        int index = officeStaffList.indexOf(officeStaffName);

        // Check if the item exists in the ArrayList
        if (index != -1) {
            //modiy new username and password to office staff list
            officeStaffList.remove(index);
        } else {
            System.out.println(officeStaffName+" not found in the list.");
        }

        System.out.println("Office Staff successfully!");
        scanner.close();
    }
}
