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

public class Lecturers {
    String Lecturer;
    String Role;
    String TypeClass;
    
    public Lecturers (String Lecturer, String Role, String TypeClass){
        this.Lecturer = Lecturer;
        this.Role = Role;
        this.TypeClass = TypeClass;
    }
    
    public String getLecturer(){
        return Lecturer;
    }
    
    public String getRole(){
        return Role;
    }
    
    public String getTypeClass(){
        return TypeClass;
    }
}
