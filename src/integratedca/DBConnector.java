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
   
//      tried to create DB    
//    public void createDB(){
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            Statement stmt = conn.createStatement();
//            stmt.execute("CREATE DATABASE bank;");
//            System.out.println("Database sucessfully created;");
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    };;
    
}
