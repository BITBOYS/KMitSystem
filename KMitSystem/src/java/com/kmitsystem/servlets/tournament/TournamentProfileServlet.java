package com.kmitsystem.servlets.tournament;

import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.services.tournament.result.GetEverythingResult;
import com.kmitsystem.services.tournament.TournamentServiceProvider;
import com.kmitsystem.services.tournament.input.DeleteTournamentInput;
import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.services.tournament.result.DeleteTournamentResult;
import com.kmitsystem.services.tournament.result.EditTournamentResult;
import com.kmitsystem.tools.DateKonverter;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Malte
 */
public class TournamentProfileServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;

    TournamentServiceProvider provider;
    GetEverythingInput input;
    GetEverythingResult result;

    Tournament tournament;

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

        this.request = request;
        this.response = response;

        String name_current = request.getParameter("tournament");

        String name_new = request.getParameter("name_new");
        String password_old = request.getParameter("password_old");
        String password_new = request.getParameter("password_new");
        String password_new2 = request.getParameter("password_new2");
        String change_leader_password = request.getParameter("password");
        String leader_new = request.getParameter("leader_new");
        String description_new = request.getParameter("description_new");
        String venue_new = request.getParameter("venue_new");
        String matchdays_new = request.getParameter("matchdays_new");
        String start_date_new = request.getParameter("start_date_new");
        String end_date_new = request.getParameter("end_date_new");
        String term_date_new = request.getParameter("term_date_new");
        String delete_tournament = request.getParameter("delete_tournament");
        String kick_team = request.getParameter("kick_team");

//##################################################
//# A L L E S   H O L E N ##########################
//##################################################
        getEverything(name_current);

//##########################################################################
//# P R E P A R E  O U T P U T  /  W R I T E  I N  S E S S I O N ###########
//##########################################################################     
        tournament = result.getTournament();
        List<Team> teams = result.getTeams();
        List<User> member = result.getMember();

//##################################################
//# T O U R N E M E N T N A M E N   Ä N D E R N ####
//##################################################
        if (!tournament.getName().equals(name_new) && name_new != null && !name_new.trim().equals("")) {
            tournament.setName(changeName(tournament.getName(), name_new));
        }

//##################################################
//# P A S S W O R T   Ä N D E R N ##################
//##################################################           
        if (password_new != null && password_new2 != null && password_new.equals(password_new2)
                && !password_new.trim().equals("") && tournament.getPassword().equals(password_old)) {
            tournament.setPassword(changePassword(password_old, password_new));
        }

//##################################################
//# L E I T E R   Ä N D E R N ######################
//##################################################        
        if (change_leader_password != null && change_leader_password.equals(tournament.getPassword())
                && !change_leader_password.trim().equals("")) {
            tournament.setLeader(new User(changeLeader(leader_new)));
        }

        
//##################################################
//# B E S C H R E I B U N G   Ä N D E R N ##########
//##################################################        
        if (description_new != null && !description_new.trim().equals("")) {
            tournament.setDescription(changeDescription(description_new));
        }
        
        
//##################################################
//# A U S T R A G U N G S O R T   Ä N D E R N ######
//##################################################        
        if (venue_new != null && !venue_new.trim().equals("")) {
            tournament.setVenue(changeVenue(venue_new));
        }        
        
 
//##################################################
//# S P I E L T A G E   Ä N D E R N ######
//##################################################        
        if (matchdays_new != null && !matchdays_new.trim().equals("")) {
            tournament.setNr_matchdays(changeMatchdays(matchdays_new));
        }    
        
        
//##################################################
//# S T A R T D A T U M   Ä N D E R N ##############
//##################################################        
        if (start_date_new != null && !start_date_new.trim().equals("")) {
            tournament.setStart_date(changeStartdate(start_date_new));
        }          
 
        
//##################################################
//# E N D D A T U M   Ä N D E R N ##################
//##################################################        
        if (end_date_new != null && !end_date_new.trim().equals("")) {
            tournament.setEnd_date(changeEnddate(end_date_new));
        } 
        
        
//##################################################
//# A N M E L D E F R I S T   Ä N D E R N ##########
//##################################################        
        if (term_date_new != null && !term_date_new.trim().equals("")) {
            tournament.setTerm_of_application(changeTermdate(term_date_new));
        }         
        
        
//##################################################
//# T U R N I E R   L Ö S C H E N ##################
//##################################################        
        if (String.valueOf(request.getParameter("action")).equals("delete")) {
            deleteTournament(delete_tournament);
        }  
        
        
//##################################################
//# T E A M   K I C K E N ##########################
//##################################################    
        if (String.valueOf(request.getParameter("action")).equals("kick")) {
            kickTeam(kick_team);
        }         
        
        /*          TODO: brauchen wir das?
        // get all users and write them into an attribute 
        List<User> users = DBUserQueries.getAllUser();
        request.setAttribute("all_users", users);

        // get all members of the tournament and write them ino an attribute
        List<User> member = DBUserTournamentQueries.getActiveUserFromTournament(tournament.getName());
        request.setAttribute("tournament_member", member);

        // get all the teams from the tournament and write them into an attribute 
        teams = DBTeamTournamentQueries.getAllTeamsFromTournament(tournament.getName());
        request.setAttribute("tournament_teams", teams);
        */
        
        request.setAttribute("tournament", tournament);
        request.setAttribute("teams", teams);
        request.setAttribute("member", member);

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.getSession().setAttribute("errors", result.getErrorList());
        }

        //response.sendRedirect("/KMitSystem/tournaments/profil");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/tournaments/profile/index.jsp");
        rd.include(request, response);
    }

    
    
    
//##################################################
//# A L L E S   H O L E N ##########################
//##################################################    
    private void getEverything(String name) {
        provider = new TournamentServiceProvider();
        input = new GetEverythingInput(name);
        result = provider.getEverything(input);
    }

//##################################################
//# T O U R N E M E N T N A M E N   Ä N D E R N ####
//##################################################
    private String changeName(String name_old, String name_new) {
        String response = name_old;

        // check if both names are equal, if true change the teamname
        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(name_old, name_new, null, null, null, null, null, null, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = name_new;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    }

//##################################################
//# P A S S W O R T   Ä N D E R N ##################
//################################################## 
    private String changePassword(String password_old, String password_new) {
        String response = password_old;

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, password_old, password_new, null, null, null, null, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = password_new;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    }
    

//##################################################
//# L E I T E R   Ä N D E R N ######################
//##################################################   
    private String changeLeader(String leader_new) {
        String response = tournament.getLeader().getUsername();

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, leader_new, null, null, null, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = leader_new;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    }
    
    
//##################################################
//# B E S C H R E I B U N G   Ä N D E R N ##########
//##################################################   
    private String changeDescription(String description_new) {
        String response = tournament.getDescription();

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, description_new, null, null, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = description_new;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    }   
    

//##################################################
//# A U S T R A G U N G S O R T   Ä N D E R N ######
//################################################## 
        private String changeVenue(String venue_new) {
        String response = tournament.getVenue();

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, null, venue_new, null, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = venue_new;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    } 

        
//##################################################
//# A U S T R A G U N G S O R T   Ä N D E R N ######
//################################################## 
        private int changeMatchdays(String matchdays_new) {
        int response = tournament.getNr_matchdays();
        int md = Integer.parseInt(matchdays_new);

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, null, null, md, null, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = md;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    } 
        
        
//##################################################
//# S T A R T D A T U M   Ä N D E R N ##############
//################################################## 
        private Date changeStartdate(String startdate_new) {
        Date response = tournament.getStart_date();
        Date startdate = (Date) DateKonverter.getSQLDate(startdate_new);

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, null, null, null, startdate, null, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = startdate;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    } 
        
        
//##################################################
//# E N D D A T U M   Ä N D E R N ##################
//################################################## 
        private Date changeEnddate(String enddate_new) {
        Date response = tournament.getEnd_date();
        Date enddate = (Date) DateKonverter.getSQLDate(enddate_new);

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, null, null, null, null, enddate, null, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = enddate;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    } 
        
        
//##################################################
//# A N M E L D U N G S D A T U M   Ä N D E R N ####
//################################################## 
        private Date changeTermdate(String termdate_new) {
        Date response = tournament.getEnd_date();
        Date termdate = (Date) DateKonverter.getSQLDate(termdate_new);

        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(tournament.getName(), null, null, null, null, null, null, null, null, null, termdate, null, null);
        EditTournamentResult result = provider.editTournament(input);

        if (result.isQuerySuccessful()) {
            response = termdate;
        }

        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }

        return response;
    } 
        
        
//##################################################
//# T U R N I E R   L Ö S C H E N ##################
//################################################## 
        private void deleteTournament(String tournament_name) {
        //Boolean response = false;
        
        provider = new TournamentServiceProvider();
        DeleteTournamentInput input = new DeleteTournamentInput(tournament_name);
        DeleteTournamentResult result = provider.deleteTournament(input);

        //response = result.isQuerySuccessful();
        
        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }
        
        //return response;
    }     
        
        
//##################################################
//# T E A M   K I C K E N ##########################
//################################################## 
        private void kickTeam(String team_name) {
        //Boolean response = false;
            
        provider = new TournamentServiceProvider();
        EditTournamentInput input = new EditTournamentInput(null, null, null, null, null, null, null, null, null, null, null, team_name, null);
        EditTournamentResult result = provider.kickTeam(input);

        //response = result.isQuerySuccessful();
        
        // write the errorlist into the session-attribute "errors"
        if (result.getErrorList().size() > 0) {
            request.setAttribute("errors", result.getErrorList());
        }
        
        //return response;
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
