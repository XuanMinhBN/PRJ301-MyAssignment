/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Semester;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface SemesterDAO {
    ArrayList<Semester> getAll() throws Exception;
    
    void addNewSemester(Semester semester) throws Exception;
    
    Semester getSemesterById(int id) throws Exception;
    
    void updateSemester() throws Exception;
}
