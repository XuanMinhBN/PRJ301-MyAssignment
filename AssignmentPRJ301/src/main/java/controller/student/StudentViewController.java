/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.student;

import controller.authentication.BaseRequiredStudentAuthenticationController;
import entity.Course;
import entity.Student;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import service.CourseService;
import service.impl.CourseServiceImpl;

/**
 *
 * @author admin
 */
public class StudentViewController extends BaseRequiredStudentAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param student
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Student student)
            throws ServletException, IOException {
        CourseService db = new CourseServiceImpl();
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        ArrayList<Course> courses = null;
        try {
            courses = db.filterByStudentID(studentId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("course", courses);
        request.setAttribute("student",student);
        request.getRequestDispatcher("../view/studentUI/student-view.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param student
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Student student)
            throws ServletException, IOException {
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
