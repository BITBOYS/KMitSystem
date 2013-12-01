
package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.result.GetEverythingResult;
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
 * @author Smadback
 */
public class TeamProfileServlet extends HttpServlet {

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
        
        String name = request.getParameter("team");
        
        TeamServiceProvider provider = new TeamServiceProvider();
        GetEverythingInput input = new GetEverythingInput(name);
        GetEverythingResult result = provider.getEverything(input);
        
        // prepare the output and write it into the session
        Team team = result.getTeam();
        List<User> member = result.getMember();
        List<Tournament> tournaments = result.getTournaments();
        
        request.setAttribute("team", team);
        request.setAttribute("member", member);
        request.setAttribute("tournaments", tournaments);
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.getSession().setAttribute("errors", result.getErrorList());
        }
        
//        User user = ((User)request.getSession().getAttribute("user") == null) ? 
//                new User("") : (User)request.getSession().getAttribute("user");
//        if(user.getUsername().equals(team.getLeader().getUsername()))
//            request.getSession().setAttribute("team", team);
        
        // redirect to the page www.kmitsystem.de/teams
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/teams/profile/index.jsp");
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
