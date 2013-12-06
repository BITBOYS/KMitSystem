/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.servlets.tournament;

import com.kmitsystem.servlets.tournament.*;
import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.SearchTeamInput;
import com.kmitsystem.services.team.result.SearchTeamResult;
import com.kmitsystem.services.tournament.TournamentServiceProvider;
import com.kmitsystem.services.tournament.input.SearchTournamentInput;
import com.kmitsystem.services.tournament.result.SearchTournamentResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
public class TournamentsServlet extends HttpServlet {

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
        
        String team =  (String)request.getParameter("team_name_search");
        String tournament = (String)request.getParameter("tournament_name_search");
        String user = request.getParameter("user_name_search");
        String createMonth = request.getParameter("createMonth_search");
        
        String running = request.getParameter("running_search");
        String finished = request.getParameter("finished_search");
        
//        was mache ich mit Boolean und Datum?
        TournamentServiceProvider provider = new TournamentServiceProvider();
        SearchTournamentInput input = new SearchTournamentInput(team, tournament, user, createMonth);
        SearchTournamentResult result = provider.searchTournament(input);
        
        // prepare the output and write it into the session
        List<Tournament> tournaments = result.getTournaments();
        
        // write the results into attributes
        request.setAttribute("tournaments", tournaments);   
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }
        
        // redirect to the page www.kmitsystem.de/touranemnts
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tournaments/index.jsp");
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
