/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Feature;
import entity.Role;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author admin
 */
public abstract class RequiredAuthenticationController extends HttpServlet{
    
    private boolean isAuthenticated(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("account");
        if(user == null){
           return false;
        }
       String current_url = request.getServletPath();
        for (Role role : user.getRoleList()) {
            for (Feature feature : role.getFeatureList()) {
                if(feature.getUrl().equals(current_url))
                    return true;
            }
        }
       return false;
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(isAuthenticated(request)){
            doGet(request, response, user);
        }
        else{
            response.getWriter().println("Access denied!");
        }  
    } 

        /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(isAuthenticated(request)){
            doPost(request, response, user);
        }
        else{
            response.getWriter().println("Access denied!");
        }
    }
    
    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException;
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException;
}
