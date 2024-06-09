/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.object;

import dao.CRUD;
import entity.User;

/**
 *
 * @author admin
 */
public interface UserDAO extends CRUD<User>{
    public User getAccount(String username, String password);
}
