/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.SemesterDAO;
import entity.Semester;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SemesterDAOImpl implements SemesterDAO, Query{

    @Override
    public ArrayList<Semester> getAll() throws Exception {
        ArrayList<Semester> semesterList = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_CURRENT_SEMESTER)
            ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Semester semester = new Semester();
                semester.setId(rs.getInt("semester_id"));
                semester.setYear(rs.getInt("semester_year"));
                semester.setSeason(rs.getString("season"));
                semester.setActive(rs.getBoolean("active"));
                semesterList.add(semester);
            }
        }
        return semesterList;
    }

    @Override
    public void addNewSemester(Semester semester) throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_SEMESTER)
            ){
            ps.setInt(1, semester.getYear());
            ps.setString(2, semester.getSeason());
            ps.setBoolean(3, semester.isActive());
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Semester getSemesterById(int id) throws Exception {
        try (
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_SEMESTER_BY_ID)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Semester semester = new Semester();
                semester.setId(rs.getInt("semester_id"));  
                semester.setYear(rs.getInt("semester_year"));
                semester.setSeason(rs.getString("season"));
                semester.setActive(rs.getBoolean("active"));
                return semester;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateSemester() throws Exception {
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_SEMESTER)
            ){
            ps.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }    
}
