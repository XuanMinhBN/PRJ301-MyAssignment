/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.AssessmentDAO;
import dao.impl.AssessmentDAOImpl;
import java.util.ArrayList;
import entity.Exam;
import service.AssessmentService;

/**
 *
 * @author admin
 */
public class AssessmentServiceImpl implements AssessmentService{
    AssessmentDAO assessmentDAO = new AssessmentDAOImpl();

    @Override
    public ArrayList<Exam> getRelatedExams(int courseId) throws Exception {
        return assessmentDAO.getRelatedExams(courseId);
    }

    
    
}
