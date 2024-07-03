/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.CourseDAO;
import dao.impl.CourseDAOImpl;
import java.util.ArrayList;
import entity.Course;
import service.CourseService;

/**
 *
 * @author admin
 */
public class CourseServiceImpl implements CourseService{
    CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public ArrayList<Course> filterByLecturerID(int lecturerId) throws Exception {
        return courseDAO.filterByLecturerID(lecturerId);
    }

    @Override
    public ArrayList<Course> filterByStudentID(int studentId) throws Exception {
        return courseDAO.filterByStudentID(studentId);
    }
}
