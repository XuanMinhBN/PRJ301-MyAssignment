/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Course;
import entity.Lecturer;
import entity.Semester;
import entity.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class CourseMapper implements RowMapper<Course>{
    @Override
    public Course mapRow(ResultSet rs) throws SQLException {
        return Course.builder()
                .id(rs.getLong("course_id"))
                .name(rs.getString("course_name"))
                .lecturer(rs.getObject("lecturer_id", Lecturer.class))
                .subject(rs.getObject("lecturer_id", Subject.class))
                .semester(rs.getObject("lecturer_id", Semester.class))
                .build();
    }
}
