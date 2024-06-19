/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connection.SQLConnection;
import dao.Query;
import dao.object.UserDAO;
import entity.Feature;
import entity.Role;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mapper.UserMapper;

/**
 *
 * @author admin
 */
public class UserDAOImpl implements UserDAO, Query{
    
    @Override
    public User getAccount(String email, String password) throws Exception {
        try (
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_USER_ACCOUNT)
        ) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Role c_role = new Role();
            User user = null;
            c_role.setId(-1L);
            while (rs.next()) {
                if (user == null) {
                    user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUsername(rs.getString("username"));
                }
                
                Long roleid = rs.getLong("role_id");
                if(roleid!=0 && c_role.getId().equals(roleid))
                {
                    c_role = new Role();
                    c_role.setId(roleid);
                    c_role.setName(rs.getString("role_name"));
                    user.getRoleList().add(c_role);
                }
                
                Long featureid = rs.getLong("feature_id");
                if(featureid != 0)
                {
                    Feature f = new Feature();
                    f.setId(featureid);
                    f.setUrl(rs.getString("url"));
                    c_role.getFeatureList().add(f);
                }
                return new UserMapper().mapRow(rs);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> ls = new ArrayList<>();
        try(
            Connection connection = SQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ALL)
        ){
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              ls.add(new UserMapper().mapRow(rs));
          }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return ls;
    }

    @Override
    public User getOne(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean save(User obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean update(User obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
