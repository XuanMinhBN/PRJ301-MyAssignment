/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import entity.Feature;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class FeatureMapper implements RowMapper<Feature>{
    @Override
    public Feature mapRow(ResultSet rs) throws SQLException {
        return Feature.builder()
                .id(rs.getLong("feature_id"))
                .url(rs.getString("url"))
                .build();
    }
}
