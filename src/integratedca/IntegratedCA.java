/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integratedca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        DBConnector db = new DBConnector();
        //db.createDB();
        
            //        try {
//            ArrayList<Students> studentsList = db.getStudents();
//            for (Students student : studentsList) {
//                System.out.println(studentsList);
//            }   
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
        try {
            Students firstStudent = db.getStudents(1);
        } catch (SQLException ex) {
            Logger.getLogger(IntegratedCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}