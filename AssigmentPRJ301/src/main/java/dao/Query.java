/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author admin
 */
public interface Query {

    //Query for UserDAO
    String GET_USER_ACCOUNT
            = "SELECT ua.username,ua.email,r.role_id,r.role_name,f.feature_id,f.url\n"
            + "FROM user_account ua\n"
            + "LEFT JOIN user_and_role ur ON ua.user_account_id = ur.user_account_id	\n"
            + "LEFT JOIN role r ON r.role_id = ur.role_id	\n"
            + "LEFT JOIN role_and_feature rf ON rf.role_id = r.role_id\n"
            + "LEFT JOIN feature f ON f.feature_id = rf.feature_id\n"
            + "WHERE ua.email = ? AND ua.password = ? AND ua.status='1'\n"
            + "ORDER BY ua.email,r.role_id,f.feature_id ASC;";
    String GET_ALL = "SELECT * FROM user_account";

    //Query for CourseDAO
    String GET_LECTURER_OF_COURSE = "SELECT c.course_id, c.course_name, c.subject_id, sub.subject_name, c.lecturer_id, s.semester_id, s.season, s.active, s.semester_year \n"
            + "FROM course c \n"
            + "INNER JOIN semester s \n"
            + "ON s.semester_id = c.semester_id\n"
            + "INNER JOIN subjects sub ON sub.subject_id = c.subject_id\n"
            + "WHERE s.active = 1 AND c.lecturer_id = ?";

    //Query for AssessmentDAO
    String GET_ASSESSMENT_TABLE = "SELECT a.assesment_id, a.assesment_name, a.weight_mark, sub.subject_id, sub.subject_name, e.exam_id, e.start_time, e.duration\n"
            + "FROM exams e \n"
            + "INNER JOIN assesment a ON e.assesment_id = a.assesment_id\n"
            + "INNER JOIN subjects sub ON sub.subject_id = a.subject_id\n"
            + "INNER JOIN course c ON c.subject_id = sub.subject_id\n"
            + "WHERE c.course_id = ?";
}
