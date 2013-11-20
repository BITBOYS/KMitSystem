/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.SearchTeamInput;
import com.kmitsystem.services.team.result.SearchTeamResult;
import com.kmitsystem.tools.objects.Team;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author v094702
 */
public class TeamsServlet extends HttpServlet {

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
        
        String team =  request.getParameter("team");
        String tournament = request.getParameter("tournament");
        String user = request.getParameter("user");
        
        TeamServiceProvider provider = new TeamServiceProvider();
        SearchTeamInput input = new SearchTeamInput(team, tournament, user);
        SearchTeamResult result = provider.searchTeam(input);
        
        // prepare the output and write it into the session
        List<Team> teams = result.getTeams();
        
        // write the results into attributes
        request.setAttribute("teams", teams);   
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }
        
        // redirect to the page www.kmitsystem.de/teams
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/teams/index.jsp");
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
