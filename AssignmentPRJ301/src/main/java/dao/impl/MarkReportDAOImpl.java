/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.MarkReportDAO;
import entity.MarkReport;
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
public class MarkReportDAOImpl implements MarkReportDAO, Query{

    @Override
    public ArrayList<MarkReport> getReportList(int id) throws Exception {
        ArrayList<MarkReport> reportList = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_REPORT)
            ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt("subject_id"));
                subject.setName(rs.getString("subject_name"));
                
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setRoll(rs.getString("roll"));
                student.setName(rs.getNString("student_name"));
                
                MarkReport report = new MarkReport();
                report.setStudentId(student);
                report.setSubjectId(subject);
                report.setAverageMark(rs.getFloat("average_mark"));
                report.setMarkStatus(rs.getBoolean("mark_status"));
                reportList.add(report);
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return reportList;
    }

    @Override
    public void insertStudentReport(int stuId, int subId) throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_AVERAGE)
            ){
            ps.setInt(1, stuId);
            ps.setInt(2, subId);
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void updateMarkStatus() throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_MARK_STATUS)
            ){
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
}
