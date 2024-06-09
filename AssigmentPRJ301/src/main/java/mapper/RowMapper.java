/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.jetbrains.annotations.Nullable;

/**
 *
 * @author admin
 */
@FunctionalInterface
public interface RowMapper<T> {
    @Nullable
    T mapRow(ResultSet rs) throws SQLException;
}
