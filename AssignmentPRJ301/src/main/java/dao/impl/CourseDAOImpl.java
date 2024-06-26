/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import constants.Query;
import dao.CourseDAO;
import java.sql.Connection;
import connection.SQLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Course;
import entity.Lecturer;
import entity.Semester;
import entity.Subject;

/**
 *
 * @author admin
 */
public class CourseDAOImpl implements CourseDAO, Query {

    @Override
    public ArrayList<Course> filterByLecturerID(int lecturerId) throws Exception {
        ArrayList<Course> courses = new ArrayList<>();
        try (
            Connection connection = SQLConnection.getConnection(); 
            PreparedStatement ps = connection.prepareStatement(GET_LECTURER_OF_COURSE)
            ) {
            ps.setInt(1, lecturerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));

                Lecturer l = new Lecturer();
                l.setId(rs.getInt("lecturer_id"));
                c.setLecturer(l);

                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setName(rs.getString("subject_name"));
                c.setSubject(sub);

                Semester sem = new Semester();
                sem.setId(rs.getInt("semester_id"));
                c.setSemester(sem);

                courses.add(c);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return courses;
    }
}
