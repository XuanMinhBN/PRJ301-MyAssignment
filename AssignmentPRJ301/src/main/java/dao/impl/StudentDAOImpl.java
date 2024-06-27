/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.StudentDAO;
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class StudentDAOImpl implements StudentDAO, Query{

    @Override
    public ArrayList<Student> getStudentsByCourse(int course_id) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_STUDENT)    
            ){
            ps.setInt(1, course_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("student_name"));
                students.add(s);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return students;
    }
    
}
