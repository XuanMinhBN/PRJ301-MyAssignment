/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

/**
 *
 * @author admin
 */
public interface Query {

    //Query for UserAccountDAO
    String GET_LECTURER_ACCOUNT
            = "SELECT u.username,u.displayname,l.lecturer_id,l.lecturer_name\n"
            + "FROM user_account u \n"
            + "LEFT JOIN lecturer_account la \n"
            + "ON la.username = u.username AND la.active = 1\n"
            + "LEFT JOIN lecturer l \n"
            + "ON la.lecturer_id = l.lecturer_id\n"
            + "WHERE u.username = ? AND u.[password] = ?";
    String GET_STUDENT_ACCOUNT
            = "SELECT u.username,u.displayname,s.student_id,s.student_name,s.roll\n"
            + "FROM user_account u \n"
            + "LEFT JOIN student_account sa \n"
            + "ON sa.username = u.username AND sa.active = 1\n"
            + "LEFT JOIN student s \n"
            + "ON sa.student_id = s.student_id\n"
            + "WHERE u.username = ? AND u.[password] = ?";

    //Query for CourseDAO
    String GET_LECTURER_OF_COURSE = "SELECT c.course_id, c.course_name, c.subject_id, sub.subject_name, c.lecturer_id, s.semester_id, s.season, s.active, s.semester_year \n"
            + "FROM course c \n"
            + "INNER JOIN semester s \n"
            + "ON s.semester_id = c.semester_id\n"
            + "INNER JOIN subjects sub ON sub.subject_id = c.subject_id\n"
            + "WHERE s.active = 1 AND c.lecturer_id = ?";
    String GET_STUDENT_OF_COURSE = "SELECT s.student_id, s.roll, s.student_name, c.course_id, c.course_name, c.subject_id, sub.subject_name, se.semester_id, se.season, se.semester_year \n"
            + "FROM student s\n"
            + "JOIN student_and_course sc\n"
            + "ON sc.student_id = s.student_id\n"
            + "JOIN course c\n"
            + "ON c.course_id = sc.course_id\n"
            + "JOIN subjects sub\n"
            + "ON c.subject_id = sub.subject_id\n"
            + "JOIN semester se\n"
            + "ON c.semester_id = se.semester_id\n"
            + "WHERE se.active = 1 AND s.student_id = ?";

    //Query for AssessmentDAO
    String GET_ASSESSMENT_TABLE = "SELECT a.assesment_id, a.assesment_name, a.weight_mark, sub.subject_id, sub.subject_name, e.exam_id, e.start_time, e.duration\n"
            + "FROM exams e \n"
            + "INNER JOIN assesment a ON e.assesment_id = a.assesment_id\n"
            + "INNER JOIN subjects sub ON sub.subject_id = a.subject_id\n"
            + "INNER JOIN course c ON c.subject_id = sub.subject_id\n"
            + "WHERE c.course_id = ?";
    String GET_ASSESSMENT_FOR_SUBJECT = "SELECT a.assesment_id, a.assesment_name, a.weight_mark, a.subject_id, sub.subject_name \n"
            + "FROM assesment a\n"
            + "JOIN subjects sub\n"
            + "ON a.subject_id = sub.subject_id\n"
            + "WHERE sub.subject_id = ?";
    String GET_ASSESSMENT_WITH_COURSE = "SELECT a.assesment_id, a.assesment_name, a.subject_id, c.course_id FROM assesment a\n"
            + "JOIN course c\n"
            + "ON a.subject_id = c.subject_id\n"
            + "WHERE c.course_id = ?";
    String GET_ASSESSMENT_BY_ID = "SELECT a.assesment_id, a.assesment_name, a.weight_mark ,a.subject_id FROM assesment a\n"
            + "JOIN subjects sub\n"
            + "ON a.subject_id = sub.subject_id\n"
            + "WHERE assesment_id = ?";

    //Query for ExamDAO
    String GET_EXAMS = "SELECT e.exam_id,e.start_time,e.duration,a.assesment_id,a.assesment_name,a.weight_mark FROM exams e INNER JOIN assesment a ON a.assesment_id = e.assesment_id\n"
            + "WHERE (1 > 2)";
    String INSERT_EXAM = "INSERT INTO [exams] "
            + "([start_time]"
            + ",[duration]"
            + ",[assesment_id])"
            + "VALUES"
            + "(?"
            + ",?"
            + ",?)";

    //Query for GradeDAO
    String GET_GRADE = "SELECT exam_id, student_id, score FROM grades WHERE (1 > 2)";
    String DELETE_GRADE_IN_STUDENT_COURSE = "DELETE FROM grades WHERE student_id IN (SELECT student_id FROM student_and_course WHERE course_id=?)";
    String INSERT_GRADE = "INSERT INTO [grades]\n"
            + "           ([exam_id]\n"
            + "           ,[student_id]\n"
            + "           ,[score])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?)";

    //Query for StudentDAO
    String SELECT_STUDENT = "SELECT s.student_id, s.student_name FROM student s INNER JOIN student_and_course sc ON sc.student_id = s.student_id\n"
            + "				INNER JOIN course c ON c.course_id = sc.course_id\n"
            + "				WHERE c.course_id = ?";
    String STUDENT_MARK_REPORT = "SELECT s.student_id, s.roll, s.student_name, sub.subject_name, a.assesment_name, a.weight_mark, g.score, e.exam_id FROM student s\n"
            + "JOIN grades g\n"
            + "ON s.student_id = g.student_id\n"
            + "JOIN exams e\n"
            + "ON e.exam_id = g.exam_id\n"
            + "JOIN assesment a\n"
            + "ON e.assesment_id = a.assesment_id\n"
            + "JOIN subjects sub\n"
            + "ON sub.subject_id = a.subject_id\n"
            + "WHERE s.student_id = ?";

    //Query for SubjectDAO
    String SELECT_ALL_SUBJECT = "SELECT * FROM subjects";

    //Alternative query
    String IDENTITY_EXAM = "SELECT @@IDENTITY as exam_id";
}
