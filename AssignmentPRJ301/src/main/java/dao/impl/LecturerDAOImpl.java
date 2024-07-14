/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.LecturerDAO;
import entity.Lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class LecturerDAOImpl implements LecturerDAO, Query{

    @Override
    public ArrayList<Lecturer> getAll() throws Exception {
        ArrayList<Lecturer> lecturerList = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_LECTURER_ONLY)
            ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId(rs.getInt("lecturer_id"));
                lecturer.setName(rs.getString("lecturer_name"));
                lecturerList.add(lecturer);
            }
        }
        return lecturerList;
    }

    @Override
    public Lecturer getLecturerById(int id) throws Exception {
        try (
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_LECTURER_BY_ID)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Lecturer lecturer = new Lecturer();
                lecturer.setId(rs.getInt("lecturer_id"));
                lecturer.setName(rs.getString("lecturer_name"));
                return lecturer;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;
    }
    
}
