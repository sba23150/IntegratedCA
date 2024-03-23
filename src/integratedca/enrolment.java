/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

/**
 *
 * @author User
 */
public class enrolment {
    String Course; 
    String Enrolment; 
    int numStudents;
    
    public enrolment (String Course, String Enrolment, int numStudents) {
        this.Course = Course; 
        this.Enrolment = Enrolment; 
        this.numStudents = numStudents;
    }
    
    public String getCourse(){
        return Course;
    }
    public String getEnrolment(){
        return Enrolment;
    }
    public int getnumStudents(){
        return numStudents;
    }
}
