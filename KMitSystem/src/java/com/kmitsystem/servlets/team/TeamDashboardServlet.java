
package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.services.team.result.EditTeamResult;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import java.util.ArrayList;
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
public class TeamDashboardServlet extends HttpServlet {

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
        String teamname = request.getParameter("team");
        String name_old  = request.getParameter("name_old");
        String tag_new = request.getParameter("tag_new");
        String password_old = request.getParameter("password_old");
        String leader_new = request.getParameter("leader_new");
        TeamServiceProvider provider;
        EditTeamInput input;
        List<Tournament> tournaments;
        
        // prepare the output
        EditTeamResult result = new EditTeamResult();
        
        // get the team
        Team team = DBTeamQueries.getTeam(teamname);
        
        
        if(!((User) request.getSession().getAttribute("user")).getUsername().equals(team.getLeader().getUsername())) {
            response.sendRedirect(request.getContextPath() + "/teams");
        }
        
        ///////////////////////////
        //CHANGE TEAMNAME SECTION//
        ///////////////////////////
        
        // check if the user filled the "change_name" form
        if(name_old != null) {
            
            // prepare the input
            String name_new  = request.getParameter("name_new");
            String name_new2 = request.getParameter("name_new2");
            
            // check if the name of the team is correct
            if(name_old.equals(teamname)) {
                // check if both names are equal, if true change the teamname
                if(name_new.equals(name_new2)) {
                    provider = new TeamServiceProvider();
                    input = new EditTeamInput(teamname, null, name_new, null, null, null, null, null, null);
                    result = provider.editTeam(input);
                    if(result.isQuerySuccessful()) team.setName(name_new);
                    
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

            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
                
        }
        
        //////////////////////////
        //CHANGE TEAMTAG SECTION//
        //////////////////////////
        
        // check if the user filled the "change_tag" form
        if(tag_new != null) {
            
            provider = new TeamServiceProvider();
            input = new EditTeamInput(teamname, null, null, tag_new, null, null, null, null, null);
            result = provider.editTeam(input);
            if(result.isQuerySuccessful()) team.setTag(tag_new);

            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
                
        }
        
        ///////////////////////////
        //CHANGE PASSWORD SECTION//
        ///////////////////////////
        
        // check if the user filled the "change_password" form
        if(password_old != null) {
            
            if(team.getPassword() == null) team.setPassword("");
            String password_new = request.getParameter("password_new");
            String password_new2 = request.getParameter("password_new2");
                    
            // check if the password of the team is correct
            if(password_old.equals(team.getPassword())) {
                // check if both passwords are equal, if true change the password
                if(password_new.equals(password_new2)) {
                    provider = new TeamServiceProvider();
                    input = new EditTeamInput(teamname, password_old, null, null, password_new, null, null, null, null);
                    result = provider.editTeam(input);
                    if(result.isQuerySuccessful()) team.setPassword(password_new);
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

            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
                
        }
        
        ///////////////////////////
        //CHANGE LEADER SECTION//
        ///////////////////////////
        
        // check if the user filled the "change_leader" form
        if(leader_new != null) {
            
            password_old = (request.getParameter("password") == null) ? "" : ""; 
            
            provider = new TeamServiceProvider();
            input = new EditTeamInput(teamname, password_old, null, null, null, leader_new, null, null, null);
            result = provider.editTeam(input);
            if(result.isQuerySuccessful()) team.setLeader(new User(leader_new));
                    
            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
                
        }
        
        ////////////////////////////
        //LEAVE TOURNAMENT SECTION//
        ////////////////////////////
        
        if(String.valueOf(request.getParameter("action")).equals("leave")) {
            String leave_tournament = request.getParameter("leave_tournament");
            
            provider = new TeamServiceProvider();
            input = new EditTeamInput(teamname, null, null, null, null, null, leave_tournament, null, null);
            result = provider.editTeam(input);
                    
            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
        }
        
        /////////////////////
        //KICK USER SECTION//
        /////////////////////
        
        if(String.valueOf(request.getParameter("action")).equals("kick")) {
            String kick_user = request.getParameter("kick_user");
            
            provider = new TeamServiceProvider();
            input = new EditTeamInput(teamname, null, null, null, null, null, null, kick_user, null);
            result = provider.editTeam(input);
                    
            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
        }
        
        // get all users and write them into an attribute 
        List<User> users = DBUserQueries.getAllUser();
        request.setAttribute("users", users);
        
        // get all members of the team and write them ino an attribute
        List<User> member = DBUserTeamQueries.getActiveUserFromTeam(team.getName());
        request.setAttribute("member", member);
        
        // get all the tournaments from the team and write them into an attribute 
        tournaments = DBTeamTournamentQueries.getAllTournamentsFromTeam(team.getName());
        request.setAttribute("tournaments", tournaments);
        
        request.setAttribute("team", team);
        // redirect to the dashboard page of the team
        rd = request.getRequestDispatcher("/WEB-INF/teams/dashboard/index.jsp");
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
