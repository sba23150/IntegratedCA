/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

/**
 *
 * @author User
 */
public class grades {
    int id;
    String Name;
    String Course; 
    String Enrolment;
    double grades;
    
    public grades (int id, String Name, String Course, String Enrolment, double grades) {
        this.id = id;
        this.Name = Name;
        this.Course = Course; 
        this.Enrolment = Enrolment;
        this.grades = grades;
    }
    
    public int getid(){
        return id;
    }
    public String getName(){
        return Name;
    }
    public String getCourse(){
        return Course;
    }
    public String getEnrolment(){
        return Enrolment;
    }
    public double getgrades(){
        return grades;
    }
}
