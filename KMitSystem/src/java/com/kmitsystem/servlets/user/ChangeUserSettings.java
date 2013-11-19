/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.user;

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

/**
 *
 * @author Oerlex
 */
public class ChangeUserSettings extends HttpServlet {

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
            String input_email_alt = request.getParameter("input_email_alt");
            String input_email_neu1 = request.getParameter("input_email_neu1");
            String input_email_neu2 = request.getParameter("input_email_neu2");
            BaseResult result = new BaseResult();

            if (DBUserQueries.isEMailExisting(input_email_alt) == true) {
                if (input_email_neu1.equals(input_email_neu2)) {
                    DBUserQueries.changeEmail(input_email_alt, input_email_neu1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.EMAILS_NOT_EQUAL);
                    result.setErrorList(errorList);
                    rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                    rd.include(request, response);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.UNKNOWN_EMAIL_ERROR);
                result.setErrorList(errorList);

                rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                rd.include(request, response);
            }

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
            String input_name_alt = request.getParameter("input_name_alt");
            String input_name_neu1 = request.getParameter("input_name_neu1");
            String input_name_neu2 = request.getParameter("input_name_neu2");
            
            BaseResult result = new BaseResult();

            if (DBUserQueries.isUsernameExisting(input_name_alt) == true) {
                if (input_name_neu1.equals(input_name_neu2)) {
                    DBUserQueries.changeName(input_name_alt, input_name_neu1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.NAMES_NOT_EQUAL);
                    result.setErrorList(errorList);
                    rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                    rd.include(request, response);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.USER_DOES_NOT_EXIST);
                result.setErrorList(errorList);

                rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                rd.include(request, response);
            }

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

         ///////////////////////////
         //CHANGE PASSWORD SECTION//
         ///////////////////////////
        
        if (request.getParameter("form_pasword") != null) {
            
            //Wie komme ich an die EMail Adresse aus der Session ?
            
            String input_password_alt = request.getParameter("input_password_alt");
            String input_password_neu1 = request.getParameter("input_password_neu1");
            String input_password_neu2 = request.getParameter("input_password_neu2");
            
            BaseResult result = new BaseResult();

            if (DBUserQueries.userPasswordOk("PLATZHALTER",input_password_alt) == true) {
                if (input_password_neu1.equals(input_password_neu2)) {
                    DBUserQueries.changePassword(input_password_alt, input_password_neu1);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.PASSWORDS_NOT_EQUAL);
                    result.setErrorList(errorList);
                    rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                    rd.include(request, response);
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.USER_DOES_NOT_EXIST);
                result.setErrorList(errorList);

                rd = request.getRequestDispatcher("/user/dahsboard/index.jsp");
                rd.include(request, response);
            }

            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

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
