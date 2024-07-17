/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.StudentDAO;
import dao.impl.StudentDAOImpl;
import entity.Grade;
import entity.Student;
import java.util.ArrayList;
import service.StudentService;

/**
 *
 * @author admin
 */
public class StudentServiceImpl implements StudentService{
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public ArrayList<Student> getStudentsByCourse(int course_id) throws Exception {
        return studentDAO.getStudentsByCourse(course_id);
    }

    @Override
    public ArrayList<Grade> getMarkForStudent(int studentId, int subjectId) throws Exception {
        return studentDAO.getMarkForStudent(studentId,subjectId);
    }

    @Override
    public ArrayList<Student> getAllStudent() throws Exception {
        return studentDAO.getAllStudent();
    }
}
