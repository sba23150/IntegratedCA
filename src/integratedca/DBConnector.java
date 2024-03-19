/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tatiana Mota - sba23150
 * GitHub: https://github.com/sba23150/IntegratedCA.git
 */

//database connection
public class DBConnector {
    private final String DB_URL = "jdbc:mysql://localhost";
    private final String USER = "pooa2024";
    private final String PASSWORD = "pooa2024";
       
    public void createDB(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE DATABASE integratedCA;");
            System.out.println("Database sucessfully created;");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //create a method to run all data from students table
    public Students getStudents(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        stmt.execute("USE integratedCA;");
        ResultSet rs = stmt.executeQuery("SELECT * from students where id="+id);
        
        rs.next();
        String name = rs.getString("name");
        String email = rs.getString("email");
        String gender = rs.getString("gender");
        String Course = rs.getString("Course");
        String Registration = rs.getString("Registration");
        String Enrolment = rs.getString("Enrolment");
        String studentNumber = rs.getString("studentNumber");
        
        conn.close();
        return new Students(name, email, gender, Course, Registration, Enrolment, studentNumber);
        
    }
    
    public ArrayList<Lecturers> getLecturers() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from lecturers;");

        ArrayList<Lecturers> lecturersList = new ArrayList<>();
        
        while (rs.next()) {
            lecturersList.add(new Lecturers());
        }
        conn.close();
        return lecturersList;
    }
}  