/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import controller.authentication.BaseRequiredLecturerAuthenticationController;
import entity.Assessment;
import entity.Exam;
import entity.Grade;
import entity.Lecturer;
import entity.Student;
import entity.UserAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashSet;
import service.ExamService;
import service.GradeService;
import service.StudentService;
import service.impl.ExamServiceImpl;
import service.impl.GradeServiceImpl;
import service.impl.StudentServiceImpl;

/**
 *
 * @author admin
 */
public class LecturerMarkController extends BaseRequiredLecturerAuthenticationController {

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
        StudentService stuDB = new StudentServiceImpl();
        ExamService examDB = new ExamServiceImpl();
        GradeService gradeDB = new GradeServiceImpl();
        String[] raw_examIds = request.getParameterValues("exam_id");
        if (raw_examIds.length == 0) {
            response.getWriter().println("You must select at least one exam");
        } else {
            int courseId = Integer.parseInt(request.getParameter("course_id"));
            ArrayList<Student> students;
            ArrayList<Assessment> assessments;
            ArrayList<Exam> exams;
            ArrayList<Grade> grades;
            try {
                students = stuDB.getStudentsByCourse(courseId);
                int[] examIds = new int[raw_examIds.length];
                for (int i = 0; i < raw_examIds.length; i++) {
                    examIds[i] = Integer.parseInt(raw_examIds[i]);
                }
                assessments = examDB.getAssessmentTable(examIds);
                grades = gradeDB.getGradesByEids(examIds);
                request.setAttribute("students", students);
                request.setAttribute("assessments", assessments);
//                request.setAttribute("exams", exams);
                request.setAttribute("grades", grades);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            request.getRequestDispatcher("../view/lecturerUI/lecturer-mark-view.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        String[] raw_gradeids = request.getParameterValues("grade_id");
        HashSet<String> examIds = new HashSet<>();
        ArrayList<Grade> grades = new ArrayList<>();
        for (String raw_gradeid : raw_gradeids) {
            int studentId = Integer.parseInt(raw_gradeid.split("_")[0]);
            int examId = Integer.parseInt(raw_gradeid.split("_")[1]);
            examIds.add(examId + "");//redirect later
            String raw_score = request.getParameter("grade" + studentId + "_" + examId);
            if (raw_score.length() > 0) {
                Grade g = new Grade();
                Student s = new Student();
                s.setId(studentId);
                Exam e = new Exam();
                e.setId(examId);
                g.setExam(e);
                g.setStudent(s);
                g.setScore(Float.parseFloat(raw_score));
                grades.add(g);
            }
        }
        GradeService db = new GradeServiceImpl();
        try {
            db.saveGradesByCourse(courseId, grades);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        String url_examId = "";
        for (String examId : examIds) {
            url_examId += "&exam_id=" + examId;
        }

        response.sendRedirect("mark?course_id=" + courseId + url_examId);
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
