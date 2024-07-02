/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.ExamDAO;
import dao.impl.ExamDAOImpl;
import entity.Assessment;
import entity.Exam;
import java.util.ArrayList;
import service.ExamService;

/**
 *
 * @author admin
 */
public class ExamServiceImpl implements ExamService{
    ExamDAO examDAO = new ExamDAOImpl();

    @Override
    public ArrayList<Exam> getExamsByEids(int[] examIds) throws Exception {
        return examDAO.getExamsByEids(examIds);
    }

    @Override
    public ArrayList<Assessment> getAssessmentTable(int[] assessmentId) throws Exception {
        return examDAO.getAssessmentTable(assessmentId);
    }
    
}
