/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.training;

import controller.authentication.BaseRequiredTrainingAuthenticationController;
import entity.Course;
import entity.Lecturer;
import entity.Semester;
import entity.Subject;
import entity.Training;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.CourseService;
import service.LecturerService;
import service.SemesterService;
import service.SubjectService;
import service.impl.CourseServiceImpl;
import service.impl.LecturerServiceImpl;
import service.impl.SemesterServiceImpl;
import service.impl.SubjectServiceImpl;

/**
 *
 * @author admin
 */
public class TrainingAddCourseController extends BaseRequiredTrainingAuthenticationController {

    LecturerService ldb = new LecturerServiceImpl();
    SemesterService sdb = new SemesterServiceImpl();
    SubjectService subdb = new SubjectServiceImpl();
    CourseService cdb = new CourseServiceImpl();

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
        try {
            ArrayList<Lecturer> lecturerList = ldb.getAll();
            ArrayList<Semester> semesterList = sdb.getAll();
            ArrayList<Subject> subjectList = subdb.getAllSubject();
            request.setAttribute("lecList", lecturerList);
            request.setAttribute("seList", semesterList);
            request.setAttribute("subList", subjectList);
        } catch (Exception ex) {
            Logger.getLogger(TrainingAddCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("../view/trainingUI/training-add-course.jsp").forward(request, response);
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
        Course course = new Course();
        try {
            String courseName = request.getParameter("course");
            String lecturerId = request.getParameter("lecturer");
            String subjectId = request.getParameter("subject");
            String semesterId = request.getParameter("semester");
            
            Lecturer lecturer = ldb.getLecturerById(Integer.parseInt(lecturerId));
            Subject subject = subdb.getSubjectById(Integer.parseInt(subjectId));
            Semester semester = sdb.getSemesterById(Integer.parseInt(semesterId));
            
            course.setName(courseName);
            course.setLecturer(lecturer);
            course.setSubject(subject);
            course.setSemester(semester);
            cdb.insertNewCourse(course);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect("/AssignmentPRJ301/training/addStudent?course_id="+course.getId());
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
