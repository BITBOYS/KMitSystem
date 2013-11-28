package com.kmitsystem.servlets.tournament;

import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.services.tournament.result.GetEverythingResult;
import com.kmitsystem.services.tournament.TournamentServiceProvider;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
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
public class TournamentProfileServlet extends HttpServlet {

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
        
        String name = request.getParameter("tournament");
        
        TournamentServiceProvider provider = new TournamentServiceProvider();
        GetEverythingInput input = new GetEverythingInput(name);
        GetEverythingResult result = provider.getEverything(input);
        
        // prepare the output and write it into the session
        Tournament tournament = result.getTuornament();
        List<Team> teams = result.getTeams();
        List<User> member = result.getMember();
        
        request.setAttribute("tournament", tournament);
        request.setAttribute("teams", teams);
        request.setAttribute("member", member);
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.getSession().setAttribute("errors", result.getErrorList());
        }
        
        // redirect to the page www.kmitsystem.de/tournaments
//        response.sendRedirect("/KMitSystem/tournaments/profil");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tournaments/profile/index.jsp");
        rd.include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
