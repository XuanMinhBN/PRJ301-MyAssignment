/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Assessment;
import entity.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class AssessmentMapper implements RowMapper<Assessment>{
    @Override
    public Assessment mapRow(ResultSet rs) throws SQLException {
        return Assessment.builder()
                .id(rs.getLong("assessment_id"))
                .name(rs.getString("assessment_name"))
                .weight(rs.getFloat("weight_mark"))
                .subject(rs.getObject("subject_id", Subject.class))
                .build();
    }
}
