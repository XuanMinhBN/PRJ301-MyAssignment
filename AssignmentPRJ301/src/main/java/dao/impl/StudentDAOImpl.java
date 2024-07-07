/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.StudentDAO;
import entity.Assessment;
import entity.Exam;
import entity.Grade;
import entity.Student;
import entity.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class StudentDAOImpl implements StudentDAO, Query {

    @Override
    public ArrayList<Student> getStudentsByCourse(int course_id) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        try (
                Connection connection = SQLConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT)) {
            ps.setInt(1, course_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("student_name"));
                students.add(s);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return students;
    }

    @Override
    public ArrayList<Grade> getMarkForStudent(int studentId) throws Exception {
        ArrayList<Grade> grade = new ArrayList<>();
        try (
                Connection connection = SQLConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(STUDENT_MARK_REPORT)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setName(rs.getString("subject_name"));

                Assessment a = new Assessment();
                a.setName(rs.getString("assesment_name"));
                a.setWeight(rs.getFloat("weight_mark"));
                a.setSubject(sub);

                Exam e = new Exam();
                e.setId(rs.getInt("exam_id"));
                e.setAssessment(a);
                
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setRoll(rs.getString("roll"));
                s.setName(rs.getNString("student_name"));

                Grade g = new Grade();
                g.setScore(rs.getFloat("score"));
                g.setExam(e);
                g.setStudent(s);
                grade.add(g);
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return grade;
    }
}
