/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import controller.authentication.BaseRequiredLecturerAuthenticationController;
import entity.Course;
import entity.Lecturer;
import entity.Subject;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CourseService;
import service.MarkReportService;
import service.SubjectService;
import service.impl.CourseServiceImpl;
import service.impl.MarkReportServiceImpl;
import service.impl.SubjectServiceImpl;

/**
 *
 * @author admin
 */
public class LecturerReportController extends BaseRequiredLecturerAuthenticationController {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param lecturer
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @param user
     * @param lecturer
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException {
        MarkReportService db = new MarkReportServiceImpl();
        SubjectService sdb = new SubjectServiceImpl();
        try {
            int courseId = Integer.parseInt(request.getParameter("course_id"));
            Subject subject = sdb.getSubjectByCourseId(courseId);
            String[] studentIds = request.getParameterValues("student_id");
            int[] studentId = new int[studentIds.length];
            for (int i = 0; i < studentIds.length; i++) {
                studentId[i] = Integer.parseInt(studentIds[i]);
                db.insertStudentReport(studentId[i], subject.getId());
                db.updateMarkStatus();
            }
            response.getWriter().println("Reported!");
        } catch (Exception e) {
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
