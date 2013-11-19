package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.result.GetEverythingResult;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * @author Maik
 */
public class CreateTeamServlet extends HttpServlet {

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
        
        if(request.getParameter("name") != null) {
            
        String name = request.getParameter("name");
        String tag = request.getParameter("tag");
        String password = request.getParameter("password");
        String reenter_password = request.getParameter("reenter_password");
//        User leader = GET USER FROM SESSION
        User leader = new User("Maik");
        BaseResult result = new BaseResult();
        
        if(password.equals(reenter_password)) {
            // first create the team
            TeamServiceProvider provider = new TeamServiceProvider();
            CreateTeamInput input = new CreateTeamInput(name, tag, password, leader);
            result = provider.createTeam(input);
            
           response.sendRedirect(request.getContextPath() + "/team/profile?team="+name);
        } else {
            List<Error> errorList = new ArrayList<Error>();
            errorList.add(Errors.PASSWORDS_NOT_EQUAL);
            result.setErrorList(errorList);
            
            rd = request.getRequestDispatcher("/teams/create/index.jsp");
            rd.include(request, response);
       }
       
       
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) 
            request.setAttribute("errors", result.getErrorList());
        
        } else {
            rd = request.getRequestDispatcher("/teams/create/index.jsp");
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
