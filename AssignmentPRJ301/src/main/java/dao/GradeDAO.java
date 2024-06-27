/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Grade;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface GradeDAO {
    ArrayList<Grade> getGradesByEids(int[] eids) throws Exception;
     void saveGradesByCourse(int courseId, ArrayList<Grade> grades) throws Exception;
}
