/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.training;

import controller.authentication.BaseRequiredTrainingAuthenticationController;
import entity.Course;
import entity.Student;
import entity.Training;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import service.CourseService;
import service.StudentService;
import service.impl.CourseServiceImpl;
import service.impl.StudentServiceImpl;

/**
 *
 * @author admin
 */
public class TrainingAddStudentIntoCourseController extends BaseRequiredTrainingAuthenticationController {

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
        StudentService stuDb = new StudentServiceImpl();
        CourseService cdb = new CourseServiceImpl(); 
        try {
            int courseId = Integer.parseInt(request.getParameter("course_id"));
            Course course = cdb.getCourseById(courseId);
            ArrayList<Student> list = stuDb.getAllStudent();
            request.setAttribute("course", course);
            request.setAttribute("studentList", list);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("../view/trainingUI/training-add-student.jsp").forward(request, response);
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
        CourseService cdb = new CourseServiceImpl();
        try {
            int courseId = Integer.parseInt(request.getParameter("course_id"));
            String[] studentIds = request.getParameterValues("student");
            int[] studentId = new int[studentIds.length];
            for (int i = 0; i < studentIds.length; i++) {
                studentId[i] = Integer.parseInt(studentIds[i]);
                cdb.insertStudentIntoCourse(studentId[i], courseId);
            }
        } catch (Exception e) {
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
