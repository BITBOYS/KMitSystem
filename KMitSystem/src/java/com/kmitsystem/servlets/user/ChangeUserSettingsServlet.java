/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.user;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.user.UserServiceProvider;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.BaseResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.services.user.input.ChangeUserEMailInput;
import com.kmitsystem.services.user.input.ChangeUserNameInput;
import com.kmitsystem.services.user.input.ChangeUserPasswordInput;

/**
 *
 * @author Oerlex
 */
public class ChangeUserSettingsServlet extends HttpServlet {

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
        RequestDispatcher rd;
        
        ////////////////////////
        //CHANGE EMAIL SECTION//
        ////////////////////////
        
        if (request.getParameter("form_email") != null) {
            String input_email_old = request.getParameter("input_email_old");
            String input_email_new1 = request.getParameter("input_email_new1");
            String input_email_new2 = request.getParameter("input_email_new2");
            BaseResult result = new BaseResult();

            UserServiceProvider provider = new UserServiceProvider();
            ChangeUserEMailInput input = new ChangeUserEMailInput(input_email_old,input_email_new1,input_email_new2);
            result = provider.changeUserEmail(input);

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        } else {
            rd = request.getRequestDispatcher("/user/dashboard/index.jsp");
            rd.include(request, response);
        }
        
        ///////////////////////
        //CHANGE NAME SECTION//
        ///////////////////////

        if (request.getParameter("form_name") != null) {
            String input_name_old = request.getParameter("input_name_old");
            String input_name_new1 = request.getParameter("input_name_new1");
            String input_name_new2 = request.getParameter("input_name_new2");
            BaseResult result = new BaseResult();
            
            UserServiceProvider provider = new UserServiceProvider();
            ChangeUserNameInput input = new ChangeUserNameInput(input_name_old,input_name_new1,input_name_new2);
            result = provider.changeUserName(input);

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }
        else {
            rd = request.getRequestDispatcher("/user/dashboard/index.jsp");
            rd.include(request, response);
        }
        
        
        
         ///////////////////////////
         //CHANGE PASSWORD SECTION//
         ///////////////////////////
        
        if (request.getParameter("form_pasword") != null) {
            
            //Wie komme ich an die EMail Adresse aus der Session ?
            
            String input_password_old = request.getParameter("input_password_old");
            String input_password_new1 = request.getParameter("input_password_new1");
            String input_password_new2 = request.getParameter("input_password_new2");            
            BaseResult result = new BaseResult();
            
            UserServiceProvider provider = new UserServiceProvider();
            ChangeUserPasswordInput input = new ChangeUserPasswordInput(input_password_old,input_password_new1,input_password_new2);
            
            result = provider.changeUserPassword(input);
            

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        }   else {
            rd = request.getRequestDispatcher("/user/dashboard/index.jsp");
            rd.include(request, response);
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
