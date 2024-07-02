/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Assessment;
import entity.Exam;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface ExamDAO {
    ArrayList<Exam> getExamsByEids(int[] examIds) throws Exception;
    
    ArrayList<Assessment> getAssessmentTable(int[] assessmentId) throws Exception;
}
