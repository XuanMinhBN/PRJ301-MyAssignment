/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.UserAccountDAO;
import dao.impl.UserAccountDAOImpl;
import entity.UserAccount;
import service.UserAccountService;

/**
 *
 * @author admin
 */
public class UserAccountServiceImpl implements UserAccountService{
    UserAccountDAO userAccountDAO = new UserAccountDAOImpl();

    @Override
    public UserAccount getUserByUsernamePassword(String username, String password) throws Exception {
        return userAccountDAO.getUserByUsernamePassword(username, password);
    }
    
}
