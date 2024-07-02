/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.authentication;

import entity.Lecturer;
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
public abstract class BaseRequiredLecturerAuthenticationController extends HttpServlet {

    private boolean isAuthenticated(HttpServletRequest request) {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (user == null) {
            return false;
        } else {
            Lecturer lecturer = user.getLecturer();
            return lecturer != null;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doGet(request, response, user, user.getLecturer());
        } else {
            response.sendRedirect("/AssignmentPRJ301/lecturer/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserAccount user = (UserAccount) request.getSession().getAttribute("user");
        if (isAuthenticated(request)) {
            doPost(request, response, user, user.getLecturer());
        } else {
            response.sendRedirect("/AssignmentPRJ301/lecturer/login");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException;

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, UserAccount user, Lecturer lecturer)
            throws ServletException, IOException;
}
