/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.user.writeUserDataServlets;

import com.kmitsystem.services.user.writeUserDataService.WriteUserDataServiceProvider;
import com.kmitsystem.services.user.writeUserDataService.input.CreateUserInput;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/CreateUserServlet"})
public class CreateUserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get the user and the team from the session and use it as input
//        User user = (User) request.getSession().getAttribute("user");
             
        Boolean fail = false;
        User user = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
        String reenter_password = request.getParameter("reenter_password"); 
        BaseResult result = null;
        
        if(user.getPassword().equals(reenter_password)){
        
            WriteUserDataServiceProvider provider = new WriteUserDataServiceProvider();
            CreateUserInput input = new CreateUserInput(user.getUsername(), user.getEmail(), user.getPassword());
            
            result = provider.createUser(input);
        }else{
            fail = true;
        }
        
        if(result.getErrorList().size() > 0 || fail) {
            request.getSession().setAttribute("errors", result.getErrorList());
            response.sendRedirect("register");
        }else{
            response.sendRedirect("login");
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
