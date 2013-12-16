package com.kmitsystem.servlets.tournament;

import com.kmitsystem.services.tournament.TournamentServiceProvider;
import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.services.tournament.result.EditTournamentResult;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.database.queries.DBUserTournamentQueries;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
@WebServlet(name = "TournamentDashboardServlet", urlPatterns = {"/TournamentDashboardServlet"})
public class TournamentDashboardServlet extends HttpServlet {

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
        String tournamentname = request.getParameter("tournament");
        String name_new = request.getParameter("name_new");
        String password_old = request.getParameter("password_old");
        String leader_new = request.getParameter("leader_new");
        String venue_new = request.getParameter("venue_new");

        TournamentServiceProvider provider;
        EditTournamentInput input;

        List<Team> teams;

        // prepare the output
        EditTournamentResult result = new EditTournamentResult();

        // get the team
        Tournament tournament = DBTournamentQueries.getTournament(tournamentname);


        if (!((User) request.getSession().getAttribute("user")).getUsername().equals(tournament.getLeader().getUsername())) {
            response.sendRedirect(request.getContextPath() + "/tournaments");
        }
        /////////////////////////////////
        //CHANGE TOURNAMENTNAME SECTION//
        ////////////////////////////////
        // check if the user filled the "change_name" form
        if (name_new != null) {

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, name_new, null, null, null, null, null, null, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setName(name_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        }

        ///////////////////////////
        //CHANGE PASSWORD SECTION//
        ///////////////////////////
        // check if the user filled the "change_password" form
        if (password_old != null) {

            if (tournament.getPassword() == null) {
                tournament.setPassword("");
            }
            String password_new = request.getParameter("password_new");
            String password_new2 = request.getParameter("password_new2");

            // check if the password of the team is correct
            if (password_old.equals(tournament.getPassword())) {
                // check if both passwords are equal, if true change the password
                if (password_new.equals(password_new2)) {
                    provider = new TournamentServiceProvider();
                    input = new EditTournamentInput(tournamentname, null, password_new, null, null, null, null, null, null);
                    result = provider.editTournament(input);
                    if (result.isQuerySuccessful()) {
                        tournament.setPassword(password_new);
                    }
                } else {
                    List<com.kmitsystem.tools.errorhandling.Error> errorList = new ArrayList<com.kmitsystem.tools.errorhandling.Error>();
                    errorList.add(Errors.PASSWORDS_NOT_EQUAL);
                    result.setErrorList(errorList);
                }
            } else {
                List<com.kmitsystem.tools.errorhandling.Error> errorList = new ArrayList<com.kmitsystem.tools.errorhandling.Error>();
                errorList.add(Errors.PASSWORD_FALSE);
                result.setErrorList(errorList);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        }

        //////////////////////////
        //CHANGE LEADER SECTION//
        ////////////////////////
        // check if the user filled the "change_leader" form
        if (leader_new != null) {

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, leader_new, null, null, null, null, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setLeader(new User(leader_new));
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }

        }

        //////////////////////////
        //CHANGE VENUE SECTION///
        ////////////////////////
        // check if the user filled the "change_venue" form
        if (venue_new != null) {

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, null, venue_new, null, null, null, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setVenue(venue_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        /////////////////////////////
        //CHANGE MATCHDAYS SECTION//
        ///////////////////////////
        // check if the user filled the "change_nr_matchdays" form
        if (Integer.valueOf(request.getParameter("nr_matchdays_new")) != null) {

            int matchdays_new = Integer.valueOf(request.getParameter("nr_matchdays_new"));

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, null, null, matchdays_new, null, null, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setNr_matchdays(matchdays_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        /////////////////////////////
        //CHANGE STARTDATE SECTION//
        ///////////////////////////
        // check if the user filled the "change_start" form
        if (Date.valueOf(request.getParameter("start_date_new")) != null) {

            Date startdate_new = Date.valueOf(request.getParameter("start_date_new"));

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, null, null, null, startdate_new, null, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setStart_date(startdate_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        ///////////////////////////
        //CHANGE ENDDATE SECTION//
        /////////////////////////
        // check if the user filled the "change_end" form
        if (Date.valueOf(request.getParameter("end_date_new")) != null) {

            Date enddate_new = Date.valueOf(request.getParameter("end_date_new"));

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, null, null, null, null, enddate_new, null);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setEnd_date(enddate_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        ////////////////////////////
        //CHANGE TERMDATE SECTION//
        //////////////////////////
        // check if the user filled the "change_term" form
        if (Date.valueOf(request.getParameter("term_date_new")) != null) {

            Date termdate_new = Date.valueOf(request.getParameter("term_date_new"));

            provider = new TournamentServiceProvider();
            input = new EditTournamentInput(tournamentname, null, null, null, null, null, null, null, termdate_new);
            result = provider.editTournament(input);
            if (result.isQuerySuccessful()) {
                tournament.setTerm_of_application(termdate_new);
            }

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        //TODO
        //////////////////////////////
        //DELETE TOURNAMENT SECTION//
        ////////////////////////////
        if (String.valueOf(request.getParameter("action")).equals("delete")) {
            String delete_tournament = request.getParameter("delete_tournament");

            provider = new TournamentServiceProvider();
//            input = new EditTeamInput(tournamentname, null, null, null, null, null, delete_tournament, null, null);
//            result = provider.editTournament(input);

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        //TODO
        /////////////////////
        //KICK TEAM SECTION//
        /////////////////////
        if (String.valueOf(request.getParameter("action")).equals("kick")) {
            String kick_team = request.getParameter("kick_user");

            provider = new TournamentServiceProvider();
//            input = new EditTournamentInput(tournamentname, null, null, null, null, null, null, kick_user, null);
//            result = provider.editTournament(input);

            // write the errorlist into the session-attribute "errors"
            if (result.getErrorList().size() > 0) {
                request.setAttribute("errors", result.getErrorList());
            }
        }

        // get all users and write them into an attribute 
        List<User> users = DBUserQueries.getAllUser();
        request.setAttribute("users", users);

        // get all members of the tournament and write them ino an attribute
        List<User> member = DBUserTournamentQueries.getActiveUserFromTournament(tournament.getName());
        request.setAttribute("member", member);

        // get all the teams from the tournament and write them into an attribute 
        teams = DBTeamTournamentQueries.getAllTeamsFromTournament(tournament.getName());
        request.setAttribute("teams", teams);

        request.setAttribute("tournament", tournament);
        // redirect to the dashboard page of the team
        rd = request.getRequestDispatcher("/WEB-INF/tournaments/profile/index.jsp");
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
