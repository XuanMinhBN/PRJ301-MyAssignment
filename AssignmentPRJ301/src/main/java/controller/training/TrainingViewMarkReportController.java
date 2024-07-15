/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.training;

import controller.authentication.BaseRequiredTrainingAuthenticationController;
import entity.MarkReport;
import entity.Subject;
import entity.Training;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import service.MarkReportService;
import service.SubjectService;
import service.impl.MarkReportServiceImpl;
import service.impl.SubjectServiceImpl;

/**
 *
 * @author admin
 */
public class TrainingViewMarkReportController extends BaseRequiredTrainingAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param acc
     * @param training
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount acc, Training training)
            throws ServletException, IOException {
        SubjectService sdb = new SubjectServiceImpl();
        try{
            ArrayList<Subject> list = sdb.getAllSubject();
            request.setAttribute("subject",list);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("../view/trainingUI/training-view-mark-report.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param acc
     * @param training
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount acc, Training training)
            throws ServletException, IOException {
        MarkReportService mdb = new MarkReportServiceImpl();
        try{
            int subjectId = Integer.parseInt(request.getParameter("subject_id"));
            ArrayList<MarkReport> reportList = mdb.getReportList(subjectId);
            request.setAttribute("report", reportList);
        }catch(Exception e){
            System.out.println(e.getMessage());
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
