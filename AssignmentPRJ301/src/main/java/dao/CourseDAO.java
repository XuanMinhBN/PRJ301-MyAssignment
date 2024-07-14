/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import entity.Course;

/**
 *
 * @author admin
 */
public interface CourseDAO {
    ArrayList<Course> filterByLecturerID(int lecturerId) throws Exception;
    
    ArrayList<Course> filterByStudentID(int studentId) throws Exception;
    
    void insertNewCourse(Course course) throws Exception;
    
    void insertStudentIntoCourse(int student, int course) throws Exception;
    
    Course getCourseById(int id) throws Exception;
}
