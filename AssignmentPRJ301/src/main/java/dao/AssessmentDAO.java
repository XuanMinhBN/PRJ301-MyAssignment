/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Assessment;
import java.util.ArrayList;
import entity.Exam;

/**
 *
 * @author admin
 */
public interface AssessmentDAO {
    ArrayList<Exam> getRelatedExams(int courseId) throws Exception;
    
    ArrayList<Assessment> getAssessment(int courseId) throws Exception;
}
