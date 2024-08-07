/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import dao.AssessmentDAO;
import dao.impl.AssessmentDAOImpl;
import entity.Assessment;
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

    @Override
    public ArrayList<Assessment> getAssessmentForSubject(int subjectId) throws Exception {
        return assessmentDAO.getAssessmentForSubject(subjectId);
    }

    @Override
    public ArrayList<Assessment> getAssessmentWithCourse(int courseId) throws Exception {
        return assessmentDAO.getAssessmentWithCourse(courseId);
    }

    @Override
    public Assessment getAssessmentById(int assessmentId) throws Exception {
        return assessmentDAO.getAssessmentById(assessmentId);
    }
}
