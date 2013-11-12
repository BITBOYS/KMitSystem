/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.servlets.user.readUserDataServlets;

import com.kmitsystem.services.user.readUserDataService.ReadUserDataServiceProvider;
import com.kmitsystem.services.user.readUserDataService.input.ReadUserDataInput;
import com.kmitsystem.services.user.writeUserDataService.WriteUserDataServiceProvider;
import com.kmitsystem.services.user.writeUserDataService.input.CreateUserInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
public class SignInServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //User Object with Input-Form-Data to validate
        User user = new User(request.getParameter("email"), request.getParameter("password"));
        
        
        ReadUserDataServiceProvider provider = new ReadUserDataServiceProvider();
        ReadUserDataInput input = new ReadUserDataInput(user);
        
        BaseResult result = provider.signInUser(input);
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.getSession().setAttribute("errors", result.getErrorList());
            response.sendRedirect("login");
        }else{
            // redirect to the page www.kmitsystem.de/teams
            response.sendRedirect("user/dashboard");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
