/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import dao.Query;
import dao.object.AssessmentDAO;
import entity.Assessment;
import entity.Exam;
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
public class AssessmentDAOImpl implements AssessmentDAO, Query{

    @Override
    public ArrayList<Exam> getRelatedExams(int id) throws Exception{
        ArrayList<Exam> exams = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection(); 
            PreparedStatement ps = connection.prepareStatement(GET_ASSESSMENT_TABLE)
        ){  
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Assessment a = new Assessment();
                a.setId(rs.getLong("assessment_id"));
                a.setName(rs.getString("assessment_name"));
                a.setWeight(rs.getFloat("weight_mark"));

                Subject sub = new Subject();
                sub.setId(rs.getLong("subject_id"));
                sub.setName(rs.getString("subject_name"));
                a.setSubject(sub);

                Exam exam = new Exam();
                exam.setId(rs.getLong("exam_id"));
                exam.setDate(rs.getTimestamp("start_time"));
                exam.setDuration(rs.getInt("duration"));
                exam.setAssessment(a);

                exams.add(exam);

            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return exams;
    }

    @Override
    public List<Exam> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Exam getOne(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(Exam obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Exam obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
