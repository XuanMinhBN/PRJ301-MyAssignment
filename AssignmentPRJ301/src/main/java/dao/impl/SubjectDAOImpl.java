/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.SubjectDAO;
import entity.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SubjectDAOImpl implements SubjectDAO, Query{

    @Override
    public ArrayList<Subject> getAllSubject() throws Exception {
        ArrayList<Subject> subjectList = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_SUBJECT)
            ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getInt("subject_id"));
                subject.setName(rs.getString("subject_name"));
                subjectList.add(subject);
            }
        }
        return subjectList;
    }
    
}
