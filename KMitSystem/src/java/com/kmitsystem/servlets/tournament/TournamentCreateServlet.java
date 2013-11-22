package com.kmitsystem.servlets.tournament;

import com.kmitsystem.services.tournament.TournamentServiceProvider;
import com.kmitsystem.services.tournament.input.CreateTournamentInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
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
import java.sql.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * @author Malte
 */
public class TournamentCreateServlet extends HttpServlet {

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

        RequestDispatcher rd;

        // get all users and write them into an attribute 
        List<Team> teams;
        teams = DBTeamQueries.getAllTeams();
        request.setAttribute("teams", teams);

        // check if the user filled the form or if he came from another page
        if (request.getParameter("tournament_name_create") != null) {

            String name = request.getParameter("tournament_name_create");
            String description = request.getParameter("tournament_description_create");
            int nrMatchdays = Integer.parseInt(request.getParameter("tournament_matchdays_create"));
            String venue = request.getParameter("tournament_venue_create");;
            String password = request.getParameter("tournament_password_creat");
            String reenter_password = request.getParameter("tournament_password_reenter_creat");
            Date startDate = Date.valueOf(request.getParameter("tournamen_start_date_create"));
            Date endDate = Date.valueOf(request.getParameter("tournamen_end_date_create"));
            Date termOfApp = Date.valueOf(request.getParameter("tournamen_term_create"));
            List<Team> teamsAdded = null; //(request.getParameter("tournament_teamAdd_create"));

//        User leader = GET USER FROM SESSION
            String leader = "Malte";
            
            BaseResult result = new BaseResult();

            if (password.equals(reenter_password)) {
                TournamentServiceProvider provider = new TournamentServiceProvider();
                CreateTournamentInput input = new CreateTournamentInput(name, password, description, new User(leader), startDate, endDate, nrMatchdays, venue, termOfApp, teamsAdded);

                result = provider.createTournament(input);
                
                // redirect to the profile of the new team
                response.sendRedirect(request.getContextPath() + "/tournament/profile?tournament="+name);
                
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.PASSWORDS_NOT_EQUAL);
                result.setErrorList(errorList);
                request.setAttribute("errors", result.getErrorList());

                // redirect to the teamcreation page and show the error
                rd = request.getRequestDispatcher("/tournaments/create/index.jsp");
                rd.include(request, response);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.getSession().setAttribute("errors", result.getErrorList());
            }

        } else {
            // redirect to the page www.kmitsystem.de/teams
            rd = request.getRequestDispatcher("/tournaments/create/index.jsp");
            rd.include(request, response);
        }
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
