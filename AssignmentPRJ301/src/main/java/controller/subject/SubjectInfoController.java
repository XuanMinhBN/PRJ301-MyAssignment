/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.subject;

import entity.Assessment;
import entity.Subject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AssessmentService;
import service.SubjectService;
import service.impl.AssessmentServiceImpl;
import service.impl.SubjectServiceImpl;

/**
 *
 * @author admin
 */
public class SubjectInfoController extends HttpServlet {

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
        SubjectService subDB = new SubjectServiceImpl();
        ArrayList<Subject> subjectList = null;
        try {
            subjectList = subDB.getAllSubject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.setAttribute("subject", subjectList);
        request.getRequestDispatcher("view/subject-view.jsp").forward(request, response);
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
        AssessmentService assessmentDB = new AssessmentServiceImpl();
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));
        ArrayList<Assessment> assessmentList = null;
        try {
            assessmentList = assessmentDB.getAssessmentForSubject(subjectId);
        } catch (Exception ex) {
            Logger.getLogger(SubjectInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("assessment", assessmentList);
        request.getRequestDispatcher("view/subject-view.jsp").forward(request, response);
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
