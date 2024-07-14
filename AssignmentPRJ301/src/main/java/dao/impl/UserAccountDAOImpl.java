/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import constants.Query;
import dao.UserAccountDAO;
import entity.Lecturer;
import entity.Student;
import entity.Training;
import entity.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class UserAccountDAOImpl implements UserAccountDAO, Query {

    @Override
    public UserAccount getLecturerByUsernamePassword(String username, String password) throws Exception {
        UserAccount user = null;
        try (
                Connection connection = SQLConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(GET_LECTURER_ACCOUNT)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserAccount();
                user.setDisplayname(rs.getString("displayname"));
                user.setUsername(username);
                int lecturerId = rs.getInt("lecturer_id");
                if (lecturerId != 0) {
                    Lecturer lecturer = new Lecturer();
                    lecturer.setId(lecturerId);
                    lecturer.setName(rs.getString("lecturer_name"));
                    user.setLecturer(lecturer);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return user;
    }

    @Override
    public UserAccount getStudentByUsernamePassword(String username, String password) throws Exception {
        UserAccount user = null;
        try (
                Connection connection = SQLConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(GET_STUDENT_ACCOUNT)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserAccount();
                user.setDisplayname(rs.getString("displayname"));
                user.setUsername(username);
                int studentId = rs.getInt("student_id");
                if (studentId != 0) {
                    Student student = new Student();
                    student.setId(studentId);
                    student.setName(rs.getNString("student_name"));
                    student.setRoll(rs.getString("roll"));
                    user.setStudent(student);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return user;
    }

    @Override
    public UserAccount getTrainingByUsernamePassword(String username, String password) throws Exception {
        UserAccount user = null;
        try (
              Connection connection = SQLConnection.getConnection(); 
              PreparedStatement ps = connection.prepareStatement(GET_TRAINING_ACCOUNT)
            ) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserAccount();
                user.setDisplayname(rs.getString("displayname"));
                user.setUsername(username);
                int trainingId = rs.getInt("training_id");
                if (trainingId != 0) {
                    Training training = new Training();
                    training.setId(trainingId);
                    training.setName(rs.getNString("training_name"));
                    user.setTraining(training);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return user;
    }

}
