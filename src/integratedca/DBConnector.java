/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
    
    
    public void courseReport(int fileFormat) throws SQLException {
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
        
        //The user should have the option to have the reports in the following formats
        switch (fileFormat){
            // txt file
            case 1:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.txt",true));
                    while (rs.next()) {
                        String courseName = rs.getString("courseName");
                        String moduleName = rs.getString("moduleName");
                        String lecturers = rs.getString("Lecturers");
                        String Room = rs.getString("Room");
                        int NumberOfStudents = rs.getInt("NumberOfStudents");
                        bw.write("Course Name: " +courseName+" ;  Module Name: "+moduleName + "; Lecturer: "+ lecturers + "; Room: "+Room+ "; number of students: "+NumberOfStudents);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to courseReport.txt successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
                
            //csv file
            case 2:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.csv",true));
                    while (rs.next()) {
                        String courseName = rs.getString("courseName");
                        String moduleName = rs.getString("moduleName");
                        String lecturers = rs.getString("Lecturers");
                        String Room = rs.getString("Room");
                        int NumberOfStudents = rs.getInt("NumberOfStudents");
                        bw.write("Course Name: " +courseName+" ;  Module Name: "+moduleName + "; Lecturer: "+ lecturers + "; Room: "+Room+ "; number of students: "+NumberOfStudents);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to courseReport.csv successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            //Output to the NetBeans Console
            case 3:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.txt",true));
                    while (rs.next()) {
                        String courseName = rs.getString("courseName");
                        String moduleName = rs.getString("moduleName");
                        String lecturers = rs.getString("Lecturers");
                        String Room = rs.getString("Room");
                        int NumberOfStudents = rs.getInt("NumberOfStudents");
                        System.out.println("Course Name: " +courseName+" ;  Module Name: "+moduleName + "; Lecturer: "+ lecturers + "; Room: "+Room+ "; number of students: "+NumberOfStudents);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data printed to console successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please type 1 for txt file, 2 for csv file or 3 for console output");
        }
        conn.close();
    }
    
    /*student report:
The name and student number of the student
■ The programme the student is undertaking
■ The modules/course the student is currently enrolled in
■ The modules that the student has completed, and the corresponding grades
■ The modules that the student needs to repeat
    */
   public void studentsReport(int fileFormat) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT \n" +
            "    students.name AS name,\n" +
            "    students.studentNumber AS studentNumber,\n" +
            "    students.course AS course,\n" +
            "    feedback.grades AS grades,\n" +
            "    feedback.feedback AS feedback\n" +
            "FROM \n" +
            "    students\n" +
            "JOIN \n" +
            "    feedback ON feedback.name = students.name;");
                
        ResultSet rs = preparedStatement.executeQuery();
        //The user should have the option to have the reports in the following formats
        switch (fileFormat){
            // txt file
            case 1:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("studentsReport.txt",true));
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String studentNumber = rs.getString("studentNumber");
                        String course = rs.getString("course");
                        String feedback = rs.getString("feedback");
                        double grades = rs.getDouble("grades");
                        bw.write("Student Name: " +name+" ;  Student Number: "+studentNumber + "; Course: "+ course + "; Grade: "+grades+ "; feedback: "+feedback);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to studentsReport.txt successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
                
            //csv file
            case 2:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.csv",true));
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String studentNumber = rs.getString("studentNumber");
                        String course = rs.getString("course");
                        String feedback = rs.getString("feedback");
                        double grades = rs.getDouble("grades");
                        bw.write("Student Name: " +name+" ;  Student Number: "+studentNumber + "; Course: "+ course + "; Grade: "+grades+ "; feedback: "+feedback);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to studentsReport.csv successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            //Output to the NetBeans Console
            case 3:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.txt",true));
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String studentNumber = rs.getString("studentNumber");
                        String course = rs.getString("course");
                        String feedback = rs.getString("feedback");
                        double grades = rs.getDouble("grades");
                        System.out.println("Student Name: " +name+" ;  Student Number: "+studentNumber + "; Course: "+ course + "; Grade: "+grades+ "; feedback: "+feedback);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data printed to console successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please type 1 for txt file, 2 for csv file or 3 for console output");
        }
        conn.close();
   }
   
   /*A Lecturer Report, that should contain:
■ The name of the lecturer
■ Their role (associate lecturer, senior lecturer, professor, programme manager)
■ The modules they are teaching this semester
■ The number of students that are taking those modules
■ The types of classes they can teach (eg Java, Web Dev, Python, Maths etc)
   */
   public void lecturerReport(int fileFormat, String lecturerName) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT \n" +
            "    lecturers.lecturer AS lecturerName,\n" +
            "    lecturers.role AS role,\n" +
            "    lecturers.typeClass AS typeClass,\n" +
            "    coursesList.modules AS modules,\n" +
            "    coursesList.enrolment AS NumberOfStudents" +
            "FROM \n" +
            "    lecturers\n" +
            "JOIN \n" +
            "    coursesList ON coursesList.teacher = lecturers.Lecturer;");
                
        ResultSet rs = preparedStatement.executeQuery();
        //The user should have the option to have the reports in the following formats
        switch (fileFormat){
            // txt file
            case 1:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("studentsReport.txt",true));
                    while (rs.next()) {
                        lecturerName = rs.getString("lecturerName");
                        String role = rs.getString("role");
                        String typeClass = rs.getString("typeClass");
                        String modules = rs.getString("modules");
                        int NumberOfStudents = rs.getInt("NumberOfStudents");
                        bw.write("Lecturer Name: " +lecturerName+" ;  role: "+role + "; modules: "+ modules + "; Number O fStudents: "+NumberOfStudents+ "; type of Class: "+typeClass);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to studentsReport.txt successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
                
            //csv file
            case 2:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.csv",true));
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String studentNumber = rs.getString("studentNumber");
                        String course = rs.getString("course");
                        String feedback = rs.getString("feedback");
                        double grades = rs.getDouble("grades");
                        bw.write("Student Name: " +name+" ;  Student Number: "+studentNumber + "; Course: "+ course + "; Grade: "+grades+ "; feedback: "+feedback);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data written to studentsReport.csv successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            //Output to the NetBeans Console
            case 3:
                try {
                    BufferedWriter bw = new BufferedWriter (new FileWriter("courseReport.txt",true));
                    while (rs.next()) {
                        String name = rs.getString("name");
                        String studentNumber = rs.getString("studentNumber");
                        String course = rs.getString("course");
                        String feedback = rs.getString("feedback");
                        double grades = rs.getDouble("grades");
                        System.out.println("Student Name: " +name+" ;  Student Number: "+studentNumber + "; Course: "+ course + "; Grade: "+grades+ "; feedback: "+feedback);
                        bw.newLine();
                    }
                    bw.close(); // Close the BufferedWriter after writing all data
                    System.out.println("Data printed to console successfully.");    
                    }
                catch (Exception e){
                    System.out.println("Error criating a new File.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please type 1 for txt file, 2 for csv file or 3 for console output");
        }
        conn.close();
   }
}  