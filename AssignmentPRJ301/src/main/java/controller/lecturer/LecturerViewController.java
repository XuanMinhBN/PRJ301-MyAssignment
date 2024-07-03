/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import controller.authentication.BaseRequiredLecturerAuthenticationController;
import entity.Assessment;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import entity.Course;
import entity.Exam;
import entity.Lecturer;
import entity.UserAccount;
import service.AssessmentService;
import service.CourseService;
import service.impl.AssessmentServiceImpl;
import service.impl.CourseServiceImpl;

/**
 *
 * @author admin
 */
public class LecturerViewController extends BaseRequiredLecturerAuthenticationController {

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
        CourseService db = new CourseServiceImpl();
        int lecturerId = Integer.parseInt(request.getParameter("lecturer_id"));
        ArrayList<Course> courses = null;
        try {
            courses = db.filterByLecturerID(lecturerId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("course", courses);
        request.getRequestDispatcher("../view/lecturerUI/lecturer-view.jsp").forward(request, response);
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
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        AssessmentService db = new AssessmentServiceImpl();
        ArrayList<Assessment> assessList = null;
        ArrayList<Exam> examList = null;
        try {
            assessList = db.getAssessment(courseId);
            examList = db.getRelatedExams(courseId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("assessment", assessList);
        request.setAttribute("exams", examList);
        request.getRequestDispatcher("../view/lecturerUI/lecturer-view.jsp").forward(request, response);
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
