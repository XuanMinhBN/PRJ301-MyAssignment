/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.UserAccount;

/**
 *
 * @author admin
 */
public interface UserAccountDAO {
    UserAccount getLecturerByUsernamePassword(String username, String password) throws Exception;
    
    UserAccount getStudentByUsernamePassword(String username, String password) throws Exception;
    
    UserAccount getTrainingByUsernamePassword(String username, String password) throws Exception;
}
