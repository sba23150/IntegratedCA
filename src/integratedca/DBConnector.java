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
    private final String DB_URL = "jdbc:mysql://localhost/CA2";
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
    public void getStudents() throws SQLException {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from students;");
            while (rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e){
            System.out.println("error");
        }
        System.out.println("Database connetion successful");
    }   
            
/*method to generate A Course Report, that should contain:
■ The name of every module
■ The programme(course) that module is in
■ The number of students enrolled in that module
■ The lecturer of that module
■ The room the module is assigned to (or “online” if it is taught online)*/
    
    
    public ArrayList<Students> courseReport() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT \n" +
"    courseslist.Course AS courseName,\n" +
"    courseslist.Modules AS moduleName,\n" +
"    courseslist.Teacher AS Lecturers,\n" +
"    courseslist.Room AS Room,\n" +
"    enrolment.num_students AS NumberOfStudents\n" +
"FROM \n" +
"    courseslist\n" +
"JOIN \n" +
"    enrolment ON courseslist.course = enrolment.course;");
                
        ResultSet rs = preparedStatement.executeQuery();
        //ArrayList<Students> courseReport = new ArrayList<>();
        
//        while (rs.next()) {
//            String courseName = rs.getString("courseName");
//            String moduleName = rs.getString("moduleName");
//            String Lecturers = rs.getString("Lecturers");
//            String Room = rs.getString("Room");
//            String NumberOfStudents = rs.getString("NumberOfStudents");
//            courseReport.add(new course(courseName, moduleName, Lecturers, Room, NumberOfStudents));
//            System.out.println("Course Name: "+ courseName+ " - Module: " + moduleName);
//        };
        conn.close();
        return courseReport;
    }
    
}  