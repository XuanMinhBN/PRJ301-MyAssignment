/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.authentication;

import entity.Student;
import entity.UserAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author admin
 */
public abstract class BaseRequiredStudentAuthenticationController extends HttpServlet{
    private boolean isAuthenticated(HttpServletRequest request) {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (user == null) {
            return false;
        } else {
            Student student = user.getStudent();
            return student != null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doGet(request, response, user, user.getStudent());
        } else {
            response.getWriter().println("Access denied!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doPost(request, response, user, user.getStudent());
        } else {
            response.getWriter().println("Access denied!");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Student lecturer)
            throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Student lecturer)
            throws ServletException, IOException;
}
