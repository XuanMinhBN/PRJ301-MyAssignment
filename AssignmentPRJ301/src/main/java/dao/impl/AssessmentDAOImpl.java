/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.AssessmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.Assessment;
import entity.Exam;
import entity.Subject;

/**
 *
 * @author admin
 */
public class AssessmentDAOImpl implements AssessmentDAO, Query{

    @Override
    public ArrayList<Exam> getRelatedExams(int courseId) throws Exception{
        ArrayList<Exam> exams = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ASSESSMENT_TABLE)
            ){
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Assessment a = new Assessment();
                a.setId(rs.getInt("assesment_id"));
                a.setName(rs.getString("assesment_name"));
                a.setWeight(rs.getFloat("weight_mark"));
                
                Subject sub= new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setName(rs.getString("subject_name"));
                a.setSubject(sub);
                
                Exam exam = new Exam();
                exam.setId(rs.getInt("exam_id"));
                exam.setDate(rs.getTimestamp("start_time"));
                exam.setDuration(rs.getInt("duration"));
                exam.setAssessment(a);
                
                exams.add(exam);
                
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return exams;
    }    

    @Override
    public ArrayList<Assessment> getAssessmentForSubject(int subjectId) throws Exception {
         ArrayList<Assessment> assessmentList = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ASSESSMENT_FOR_SUBJECT)
            ){
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Assessment a = new Assessment();
                a.setId(rs.getInt("assesment_id"));
                a.setName(rs.getString("assesment_name"));
                a.setWeight(rs.getFloat("weight_mark"));
                
                Subject sub= new Subject();
                sub.setId(rs.getInt("subject_id"));
                sub.setName(rs.getString("subject_name"));
                a.setSubject(sub);
                
                assessmentList.add(a);
                
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return assessmentList;
    }
}
