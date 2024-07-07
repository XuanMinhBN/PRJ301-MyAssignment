/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Grade;
import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface StudentDAO {
    ArrayList<Student> getStudentsByCourse(int courseId) throws Exception;
    
    ArrayList<Grade> getMarkForStudent(int studentId) throws Exception;
}
