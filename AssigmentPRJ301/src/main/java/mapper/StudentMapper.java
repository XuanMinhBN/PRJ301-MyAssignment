/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class StudentMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs) throws SQLException {
        return Student.builder()
                .id(rs.getLong("student_id"))
                .studentRoll(rs.getString("roll"))
                .studentName(rs.getNString("student_name"))
                .build();
    }
    
}
