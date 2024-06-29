/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.ExamDAO;
import entity.Assessment;
import entity.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ExamDAOImpl implements ExamDAO ,Query{

    @Override
    public ArrayList<Exam> getExamsByEids(int[] examIds) throws Exception {
        ArrayList<Exam> exams = new ArrayList<>();
        String sql = GET_EXAMS;
        for (int examId : examIds) {
            sql+= " OR exam_id = ? ";
        }
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)
            ){
            for (int i = 0; i < examIds.length; i++) {
                ps.setInt((i+1), examIds[i]);
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Assessment a = new Assessment();
                a.setId(rs.getInt("assesment_id"));
                a.setName(rs.getString("assesment_name"));
                a.setWeight(rs.getFloat("weight_mark"));
                
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
    
}
