/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Role;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class RoleMapper implements RowMapper<Role>{

    @Override
    public Role mapRow(ResultSet rs) throws SQLException {
        return Role.builder()
                .id(rs.getLong("role_id"))
                .name(rs.getString("role_name"))
                .build();
    }
    
}
