/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.object;

import dao.CRUD;
import entity.Assessment;
import entity.Exam;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface AssessmentDAO extends CRUD<Exam>{
    ArrayList<Exam> getRelatedExams(int id) throws Exception;
}
