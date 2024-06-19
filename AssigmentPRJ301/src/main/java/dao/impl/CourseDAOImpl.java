/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import dao.Query;
import dao.object.CourseDAO;
import entity.Course;
import entity.Lecturer;
import entity.Semester;
import entity.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class CourseDAOImpl implements CourseDAO, Query{

    @Override
    public ArrayList<Course> filterByLecturerID(int id) throws Exception {
        ArrayList<Course> courses = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_LECTURER_OF_COURSE)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getLong("course_id"));
                c.setName(rs.getString("course_name"));

                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lecturer_id"));
                c.setLecturer(l);

                Subject sub = new Subject();
                sub.setId(rs.getLong("subject_id"));
                sub.setName(rs.getString("subject_name"));
                c.setSubject(sub);
                
                Semester sem = new Semester();
                sem.setId(rs.getLong("semester_id"));
                c.setSemester(sem);

                courses.add(c);
            } 
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return courses;
    }

    @Override
    public List<Course> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Course getOne(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Course obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Course obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
