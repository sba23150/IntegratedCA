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
    private final String DB_URL = "jdbc:mysql://localhost:3306/CA2";
    private final String USER = "pooa2024";
    private final String PASSWORD = "pooa2024";
    
//    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//    Statement stmt = conn.createStatement();
//    ResultSet rs = stmt.executeQuery("SELECT * from Students");
//    
//        ResultSet rsStudents = db.createStatement().executeQuery("SELECT * FROM STUDENTS");
//        
//        while (rsStudents.next()){
//        System.out.println("Name: " + rsStudents.getString(""));
//        }
   
    public ArrayList<Students> getStudents() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Students;");
        
        ResultSet rs = preparedStatement.executeQuery();
//        rs.next();
        ArrayList<Students> studentsList = new ArrayList<>();
        
        while (rs.next()) {
            studentsList.add(new Students());
        }
        conn.close();
        return studentsList;
    }
}  