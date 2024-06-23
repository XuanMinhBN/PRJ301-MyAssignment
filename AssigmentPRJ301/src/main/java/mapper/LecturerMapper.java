/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Lecturer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class LecturerMapper implements RowMapper<Lecturer>{

    @Override
    public Lecturer mapRow(ResultSet rs) throws SQLException {
        return Lecturer.builder()
                .id(rs.getLong("lecturer_id"))
                .name(rs.getNString("lecturer_name"))
                .build();
    }
    
}
