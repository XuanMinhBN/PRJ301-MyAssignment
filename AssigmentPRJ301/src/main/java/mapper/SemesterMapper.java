/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Semester;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SemesterMapper implements RowMapper<Semester>{
    @Override
    public Semester mapRow(ResultSet rs) throws SQLException {
        return Semester.builder()
                .id(rs.getLong("semester_id"))
                .semesterYear(rs.getInt("semester_year"))
                .season(rs.getString("season"))
                .active(rs.getBoolean("active"))
                .build();
    }
}
