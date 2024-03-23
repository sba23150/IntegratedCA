/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

/**
 *
 * @author User
 */
public class course {

    String courseName;
    String moduleName;
    String Lecturers;
    String Room;
    
    public course(String courseName, String moduleName, String Lecturers, String Room) {
        this.courseName = courseName;
        this.moduleName = moduleName;
        this.Lecturers = Lecturers;
        this.Room = Room;
    }
    
    public String getcourseName(){
        return courseName;
    }
    public String getmoduleName(){
        return moduleName;
    }
    public String getLecturers(){
        return Lecturers;
    }
    public String getRoom(){
        return Room;
    }
    
}
