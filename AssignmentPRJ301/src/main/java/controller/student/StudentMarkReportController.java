/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.student;

import controller.authentication.BaseRequiredStudentAuthenticationController;
import entity.Grade;
import entity.Student;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 *
 * @author admin
 */
public class StudentMarkReportController extends BaseRequiredStudentAuthenticationController {

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
        StudentService studentService = new StudentServiceImpl();
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));
        ArrayList<Grade> gradeList = null;
        try {
            gradeList = studentService.getMarkForStudent(studentId,subjectId);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("grade", gradeList);
        request.setAttribute("aStudent", student);
        request.setAttribute("studentId", studentId);
        request.setAttribute("subjectId", subjectId);
        request.getRequestDispatcher("../view/studentUI/student-mark-report.jsp").forward(request, response);
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
