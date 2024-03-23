/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

/**
 *
 * @author User
 */
public class feedback {
    int id;
    String Name;
    String Course;
    String Enrolment;
    double grades; 
    String feedback;
    
    public feedback (int id, String Name, String Course, String Enrolment, double grades, String feedback){
        this.id = id;
        this.Name = Name;
        this.Course = Course;
        this.Enrolment = Enrolment;
        this.grades = grades; 
        this.feedback = feedback;
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
    public String getfeedback(){
        return feedback;
    }
}
