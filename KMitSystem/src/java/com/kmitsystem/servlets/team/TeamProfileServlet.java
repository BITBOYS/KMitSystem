
package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.result.EditTeamResult;
import com.kmitsystem.services.team.result.GetEverythingResult;
import com.kmitsystem.tools.errorhandling.Errors;
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
public class TeamProfileServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;
    
    TeamServiceProvider provider;
    GetEverythingInput input;
    GetEverythingResult result;
    
    Team team;
    
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
        
        String name = request.getParameter("team");
        String name_new  = request.getParameter("name_new");
        String tag_new  = request.getParameter("tag_new");
        String password_old = request.getParameter("password_old");
        String password_new = request.getParameter("password_new");
        String password_new2 = request.getParameter("password_new2");
        
//##################################################
//# A L L E S # H O L E N ##########################
//##################################################
        getEverything(name);
        // prepare the output
        team = result.getTeam();
        List<User> member = result.getMember();
        List<Tournament> tournaments = result.getTournaments();
        
//##################################################
//# T E A M N A M E N # Ä N D E R N ################
//##################################################
        if(!team.getName().equals(name_new) && name_new != null && !name_new.trim().equals("")) { 
            team.setName(changeName(team.getName(), name_new));
        }
        
//##################################################
//# T E A M T A G # Ä N D E R N ####################
//##################################################           
        if (!team.getTag().equals(tag_new) && tag_new != null && !tag_new.trim().equals("")) {
            team.setTag(changeTag(tag_new));
        }
        
//##################################################
//# P A S S W O R T # Ä N D E R N ##################
//##################################################           
        if (password_new != null && password_new2 != null && password_new.equals(password_new2) && 
                   !password_new.trim().equals("") && team.getPassword().equals(password_old)) {
            team.setPassword(changePassword(password_old, password_new));
        }        
        
        request.setAttribute("team", team);
        request.setAttribute("member", member);
        request.setAttribute("tournaments", tournaments);
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) {
            request.getSession().setAttribute("errors", result.getErrorList());
        }
        
        // redirect to the page www.kmitsystem.de/teams
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/teams/profile/index.jsp");
        rd.include(request, response);
    }
    
    private void getEverything(String name) {
        provider = new TeamServiceProvider();
        input = new GetEverythingInput(name);
        result = provider.getEverything(input);
    }

//##################################################
//# T E A M N A M E N # Ä N D E R N ################
//##################################################
    private String changeName(String name_old, String name_new) {
        String response = name_old;
        
        // check if both names are equal, if true change the teamname
        provider = new TeamServiceProvider();
        EditTeamInput input = new EditTeamInput(name_old, null, name_new, null, null, null, null, null, null);
        EditTeamResult result = provider.editTeam(input);
        
        if(result.isQuerySuccessful()) 
            response = name_new;

        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) 
            request.setAttribute("errors", result.getErrorList());
                
        return response;
    }
    
//##################################################
//# T E A M T A G # Ä N D E R N ####################
//##################################################  
    private String changeTag(String tag_new) {
        String response = team.getTag();
        
        // check if both names are equal, if true change the teamname
        provider = new TeamServiceProvider();
        EditTeamInput input = new EditTeamInput(team.getName(), null, null, tag_new, null, null, null, null, null);
        EditTeamResult result = provider.editTeam(input);
        
        if(result.isQuerySuccessful()) 
            response = tag_new;

        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) 
            request.setAttribute("errors", result.getErrorList());
                
        return response;
    }

//##################################################
//# P A S S W O R T # Ä N D E R N ##################
//################################################## 
    private String changePassword(String password_old, String password_new) {
        String response = password_old;
        
        provider = new TeamServiceProvider();
        EditTeamInput input = new EditTeamInput(team.getName(), password_old, null, null, password_new, null, null, null, null);
        EditTeamResult result = provider.editTeam(input);
            
        if(result.isQuerySuccessful()) 
            response = password_new;
        
        // write the errorlist into the session-attribute "errors"
        if(result.getErrorList().size() > 0) 
            request.setAttribute("errors", result.getErrorList());
        
        return response;
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
