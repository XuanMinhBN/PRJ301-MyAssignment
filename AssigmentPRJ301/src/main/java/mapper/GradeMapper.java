/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Exam;
import entity.Grade;
import entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class GradeMapper implements RowMapper<Grade>{
    @Override
    public Grade mapRow(ResultSet rs) throws SQLException {
        return Grade.builder()
                .exam(rs.getObject("exam_id", Exam.class))
                .student(rs.getObject("student_id", Student.class))
                .score(rs.getFloat("score"))
                .build();
    }
}
