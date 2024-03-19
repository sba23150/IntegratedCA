/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca;

/**
 *
 * @author Tatiana Mota - sba23150
 * GitHub: https://github.com/sba23150/IntegratedCA.git
 */

public class Students {
    String name;
    String email;
    String gender;
    String Course;
    String Registration;
    String Enrolment;
    String studentNumber;
    
    public Students (String name, String email, String gender, String Course, String Registration, String Enrolment, String studentNumber){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.Course = Course;
        this.Registration = Registration;
        this.Enrolment = Enrolment;
        this.studentNumber = studentNumber;
    }
    
    public String getname(){
        return name;
    }
    
    public String getemail(){
        return email;
    }
    
    public String getgender(){
        return gender;
    }
    
    public String getCourse(){
        return Course;
    }
    
    public String getRegistration(){
        return Registration;
    }
    
    public String getEnrolment(){
        return Enrolment;
    }
    
    public String getstudentNumber(){
        return studentNumber;
    }
    
}
