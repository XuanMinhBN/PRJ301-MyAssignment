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
import entity.Student;
import entity.StudentAndCourse;
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

    @Override
    public ArrayList<Course> filterByStudentID(int studentId) throws Exception {
        ArrayList<Course> courses = new ArrayList<>();
        try (
            Connection connection = SQLConnection.getConnection(); 
            PreparedStatement ps = connection.prepareStatement(GET_STUDENT_OF_COURSE)
            ) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setRoll(rs.getString("roll"));
                s.setName(rs.getNString("student_name"));

                StudentAndCourse sc = new StudentAndCourse();
                sc.setStudentId(s);
                
                Course c = new Course();
                c.setId(rs.getInt("course_id"));
                c.setName(rs.getString("course_name"));
                
                sc.setCourseId(c);

                Subject sub = new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setName(rs.getString("subject_name"));
                c.setSubject(sub);

                Semester sem = new Semester();
                sem.setId(rs.getInt("semester_id"));
                sem.setSeason(rs.getString("season"));
                sem.setYear(rs.getInt("semester_year"));
                c.setSemester(sem);

                courses.add(c);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return courses;
    }

    @Override
    public void insertNewCourse(Course course) throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_COURSE)
            ){
            ps.setString(1, course.getName());
            ps.setInt(2, course.getLecturer().getId());
            ps.setInt(3, course.getSubject().getId());
            ps.setInt(4, course.getSemester().getId());
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void insertStudentIntoCourse(int student, int course) throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_STUDENT_IN_COURSE)
            ){
            ps.setInt(1, student);
            ps.setInt(2, course);
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Course getCourseById(int id) throws Exception {
        try (
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_COURSE_BY_ID)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("course_name"));
                return course;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;
    }
}
