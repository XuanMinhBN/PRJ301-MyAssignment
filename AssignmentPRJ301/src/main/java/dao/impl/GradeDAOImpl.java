/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.GradeDAO;
import entity.Exam;
import entity.Grade;
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class GradeDAOImpl implements GradeDAO, Query{

    @Override
    public ArrayList<Grade> getGradesByEids(int[] examIds) throws Exception {
        ArrayList<Grade> grades = new ArrayList<>();
        String sql = GET_GRADE;
        for (int examId : examIds) {
            sql += " OR exam_id = ? ";
        }
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
            ){
            for (int i = 0; i < examIds.length; i++) {
                ps.setInt((i + 1), examIds[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exam exam = new Exam();
                exam.setId(rs.getInt("exam_id"));

                Student s = new Student();
                s.setId(rs.getInt("student_id"));

                Grade g = new Grade();
                g.setExam(exam);
                g.setStudent(s);
                g.setScore(rs.getFloat("score"));

                grades.add(g);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return grades;
    }

    @Override
    public void saveGradesByCourse(int courseId, ArrayList<Grade> grades) throws Exception {
        Connection connection = SQLConnection.getConnection();
        PreparedStatement stm_delete = null;
        ArrayList<PreparedStatement> stm_insests = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            stm_delete = connection.prepareStatement(DELETE_GRADE_IN_STUDENT_COURSE);
            stm_delete.setInt(1, courseId);
            stm_delete.executeUpdate();
            
            for (Grade grade : grades) {
                PreparedStatement stm_insert = connection.prepareStatement(INSERT_GRADE);
                stm_insert.setInt(1, grade.getExam().getId());
                stm_insert.setInt(2, grade.getStudent().getId());
                stm_insert.setFloat(3, grade.getScore());
                stm_insert.executeUpdate();
                stm_insests.add(stm_insert);
            }
            
            connection.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        }finally{
            try {
                connection.setAutoCommit(true);
                stm_delete.close();
                for (PreparedStatement stm_insest : stm_insests) {
                    stm_insest.close();
                }
                connection.close();
            } catch (SQLException ex) {
                throw new Exception(ex.getMessage());
            }
        }
    }
    
}
