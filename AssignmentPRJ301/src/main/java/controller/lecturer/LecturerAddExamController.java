/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import controller.authentication.BaseRequiredLecturerAuthenticationController;
import entity.Assessment;
import entity.Exam;
import entity.Lecturer;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import service.AssessmentService;
import service.ExamService;
import service.impl.AssessmentServiceImpl;
import service.impl.ExamServiceImpl;

/**
 *
 * @author admin
 */
public class LecturerAddExamController extends BaseRequiredLecturerAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException {
        AssessmentService assessService = new AssessmentServiceImpl();
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        ArrayList<Assessment> assessmentList = null;
        try {
            assessmentList = assessService.getAssessmentWithCourse(courseId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("assessment", assessmentList);
        request.getRequestDispatcher("../view/lecturerUI/lecturer-add-exam.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException {
        ExamService examService = new ExamServiceImpl();
        AssessmentService assessmentService = new AssessmentServiceImpl();
        try {
            Date startTime = Date.valueOf(request.getParameter("start_time"));
            int duration = Integer.parseInt(request.getParameter("duration"));
            int assessmentId = Integer.parseInt(request.getParameter("assessment_id"));
            Assessment assessment = assessmentService.getAssessmentById(assessmentId);

            Exam exam = new Exam();
            exam.setDate(startTime);
            exam.setDuration(duration);
            exam.setAssessment(assessment);
            examService.insertExam(exam);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        response.sendRedirect("/AssignmentPRJ301/lecturer/view?lecturer_id="+lecturer.getId());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
