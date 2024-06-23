/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Course;
import entity.Exam;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import service.AssessmentService;
import service.CourseService;
import service.impl.AssessmentServiceImpl;
import service.impl.CourseServiceImpl;

/**
 *
 * @author admin
 */
public class LecturerViewExamController extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CourseService courseDB = new CourseServiceImpl();
            int lecturer_id = Integer.parseInt(request.getParameter("lecturer_id"));
            ArrayList<Course> courses = courseDB.filterByLecturerID(lecturer_id);
            request.setAttribute("course", courses);
            request.getRequestDispatcher("../view/lecturer-view.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        AssessmentService assessmentDB = new AssessmentServiceImpl();
        try {
            ArrayList<Exam> exams = assessmentDB.getRelatedExams(course_id);
            request.setAttribute("exams", exams);
            request.getRequestDispatcher("../view/lecturer-view.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
