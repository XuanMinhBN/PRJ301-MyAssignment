/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.object;

import dao.CRUD;
import entity.Course;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface CourseDAO extends CRUD<Course>{
    ArrayList<Course> filterByLecturerID(int id) throws Exception;
}
