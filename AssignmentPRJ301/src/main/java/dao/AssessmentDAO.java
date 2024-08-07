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
    
    ArrayList<Assessment> getAssessmentForSubject(int subjectId) throws Exception;
    
    ArrayList<Assessment> getAssessmentWithCourse(int courseId) throws Exception;
    
    Assessment getAssessmentById(int assessmentId) throws Exception;
}
