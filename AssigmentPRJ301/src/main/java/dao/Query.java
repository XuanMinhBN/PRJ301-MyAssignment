/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author admin
 */
public interface Query {

    //Query for UserDAO
    String GET_USER_ACCOUNT = 
            "SELECT \n"
            + "	ua.username,\n"
            + "	ua.email,\n"
            + "	r.roleid,\n"
            + "	r.rolename,\n"
            + "	f.featureid,\n"
            + "	f.url\n"
            + "FROM user_account ua \n"
            + "	LEFT JOIN user_and_role ur ON ua.id = ur.user_account_id\n"
            + "	LEFT JOIN role r ON r.id = ur.role_id\n"
            + "	LEFT JOIN role_and_feature rf ON rf.role_id = r.id\n"
            + "	LEFT JOIN feature f ON f.id = rf.feature_id\n"
            + "WHERE ua.email = ? AND ua.password = ?\n"
            + "ORDER BY ua.email,r.id,f.id ASC";
}
