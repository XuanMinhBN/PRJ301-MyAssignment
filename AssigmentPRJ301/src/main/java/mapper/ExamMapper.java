/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Assessment;
import entity.Exam;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ExamMapper implements RowMapper<Exam>{
    @Override
    public Exam mapRow(ResultSet rs) throws SQLException {
        return Exam.builder()
                .id(rs.getLong("exam_id"))
                .date(rs.getDate("start_time"))
                .duration(rs.getInt("duration"))
                .assessment(rs.getObject("assessment_id",Assessment.class))
                .build();
    }
}
