/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Lecturer;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface LecturerDAO {
    ArrayList<Lecturer> getAll() throws Exception;
    
    Lecturer getLecturerById(int id) throws Exception;
}
