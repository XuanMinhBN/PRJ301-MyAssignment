/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    private String username;
    private String password;
    private String displayname;
    private Lecturer lecturer;
    private Student student;
    private Training training;
}
