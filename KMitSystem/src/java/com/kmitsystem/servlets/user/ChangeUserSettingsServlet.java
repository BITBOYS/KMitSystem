/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.user;

import com.kmitsystem.services.user.UserServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmitsystem.services.user.input.ChangeUserEMailInput;
import com.kmitsystem.services.user.input.ChangeUserNameInput;
import com.kmitsystem.services.user.input.ChangeUserPasswordInput;
import com.kmitsystem.services.user.result.ChangeUserSettingsResult;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.objects.User;
import java.util.ArrayList;
import java.util.List;

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
        ChangeUserSettingsResult result = new ChangeUserSettingsResult();
        User user = (User)request.getSession().getAttribute("user");
        
        System.out.println(result.getUser());
        
        ////////////////////////
        //CHANGE EMAIL SECTION//
        ////////////////////////
        
        if (request.getParameter("input_email_old") != null) {
            String input_email_old = request.getParameter("input_email_old");
            String input_email_new1 = request.getParameter("input_email_new1");
            String input_email_new2 = request.getParameter("input_email_new2");

            // check if the email of the user is correct
            if(input_email_old.equals(user.getEmail())) {
                // check if both emails are equal, if true change the email
                if(input_email_new1.equals(input_email_new2)) {
                    UserServiceProvider provider = new UserServiceProvider();
                    ChangeUserEMailInput input = new ChangeUserEMailInput(input_email_old,input_email_new1,input_email_new2);
                    result = provider.changeUserEmail(input);
                    // if the query was successful, write the new email into the user object
                    if(result.isQuerySuccess()) user.setEmail(input_email_new1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.EMAILS_NOT_EQUAL);
                    result.setErrorList(errorList);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.EMAIL_IS_FALSE);
                result.setErrorList(errorList);
            }
            
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        } 
        
        
        ///////////////////////
        //CHANGE NAME SECTION//
        ///////////////////////

        if (request.getParameter("input_name_old") != null) {
            String input_name_old = request.getParameter("input_name_old");
            String input_name_new1 = request.getParameter("input_name_new1");
            String input_name_new2 = request.getParameter("input_name_new2");
            
            // check if the email of the user is correct
            if(input_name_old.equals(user.getUsername())) {
                // check if both names are equal, if true change the name
                if(input_name_new1.equals(input_name_new2)) {
                    UserServiceProvider provider = new UserServiceProvider();
                    ChangeUserNameInput input = new ChangeUserNameInput(input_name_old,input_name_new1,input_name_new2);
                    result = provider.changeUserName(input);
                    // if the query was successful, write the new username into the user object
                    if(result.isQuerySuccess()) user.setUsername(input_name_new1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.NAMES_NOT_EQUAL);
                    result.setErrorList(errorList);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.NAME_IS_FALSE);
                result.setErrorList(errorList);
            }
            
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }
        
        
         ///////////////////////////
         //CHANGE PASSWORD SECTION//
         ///////////////////////////
        
        if (request.getParameter("input_password_old") != null) {
            
            //Wie komme ich an die EMail Adresse aus der Session ?
            
            String input_password_old = request.getParameter("input_password_old");
            String input_password_new1 = request.getParameter("input_password_new1");
            String input_password_new2 = request.getParameter("input_password_new2"); 
            
            // check if the email of the user is correct
            if(input_password_old.equals(user.getPassword())) {
                // check if both names are equal, if true change the name
                if(input_password_new1.equals(input_password_new2)) {
                    UserServiceProvider provider = new UserServiceProvider();
                    ChangeUserPasswordInput input = new ChangeUserPasswordInput(user.getUsername(),input_password_old,input_password_new1,input_password_new2);
                    result = provider.changeUserPassword(input);
                    // if the query was successful, write the new password into the user object
                    if(result.isQuerySuccess()) user.setPassword(input_password_new1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.PASSWORDS_NOT_EQUAL);
                    result.setErrorList(errorList);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.PASSWORD_FALSE);
                result.setErrorList(errorList);
            }

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            } else {
                result.getUser().setPassword(input_password_new1);
            }

        }
        
        // write the user object into the session
        request.getSession().setAttribute("user", user);
        
        rd = request.getRequestDispatcher("/WEB-INF/user/dashboard/index.jsp");
        rd.include(request, response);
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
