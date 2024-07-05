/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Exam;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface ExamDAO {
    ArrayList<Exam> getExamsByEids(int[] examIds) throws Exception;
    
    void insertExam(Exam exam) throws Exception;
}
