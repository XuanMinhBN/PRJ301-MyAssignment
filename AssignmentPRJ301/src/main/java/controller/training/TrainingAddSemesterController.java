/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.training;

import controller.authentication.BaseRequiredTrainingAuthenticationController;
import entity.Semester;
import entity.Training;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SemesterService;
import service.impl.SemesterServiceImpl;

/**
 *
 * @author admin
 */
public class TrainingAddSemesterController extends BaseRequiredTrainingAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param training
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Training training)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/trainingUI/training-add-semester.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param training
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Training training)
            throws ServletException, IOException {
        SemesterService sedb = new SemesterServiceImpl();
        Semester semester = new Semester();
        try{
            int year = Integer.parseInt(request.getParameter("year"));
            String season = request.getParameter("season");
            semester.setYear(year);
            semester.setSeason(season);
            semester.setActive(true);
            sedb.updateSemester();
            sedb.addNewSemester(semester);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        response.sendRedirect("/AssignmentPRJ301/training/view");
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
