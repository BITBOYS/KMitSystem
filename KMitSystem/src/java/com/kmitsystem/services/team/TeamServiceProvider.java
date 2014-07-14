package com.kmitsystem.services.team;

import com.kmitsystem.services.team.input.AddPlayerInput;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.input.SearchTeamInput;
import com.kmitsystem.services.team.result.EditTeamResult;
import com.kmitsystem.services.team.result.GetEverythingResult;
import com.kmitsystem.services.team.result.SearchTeamResult;
import com.kmitsystem.services.team.validator.AddPlayerValidator;
import com.kmitsystem.services.team.validator.CreateTeamValidator;
import com.kmitsystem.services.team.validator.EditTeamValidator;
import com.kmitsystem.services.team.validator.GetEverythingValidator;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.BaseResult;

/**
 * @author Maik
 */
public class TeamServiceProvider {
    
    CreateTeamValidator createTeamValidator = new CreateTeamValidator();
    AddPlayerValidator addPlayerValidator = new AddPlayerValidator();
    GetEverythingValidator getEverythingValidator = new GetEverythingValidator();
    EditTeamValidator editTeamValidator = new EditTeamValidator();
    
    public BaseResult createTeam(CreateTeamInput input) {
        BaseResult result = new BaseResult();

        if(createTeamValidator.validate(input)) {
            // prepare the input
            String name = input.getName();
            String tag = input.getTag();
            String password = input.getPassword();
            String leader = input.getLeader();
            
            // call the database
            DBTeamQueries.createTeam(name, tag, password, leader);
            DBUserTeamQueries.addPlayer(leader, name);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
    public BaseResult addPlayer(AddPlayerInput input) {
        BaseResult result = new BaseResult();
        
        if(addPlayerValidator.validate(input)) {
            // prepare the input
            String teamname = input.getTeamname();
            String username = input.getUsername();
            
            // call the database
            DBUserTeamQueries.addPlayer(username, teamname);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    public GetEverythingResult getEverything(GetEverythingInput input) {
        GetEverythingResult result = new GetEverythingResult();
        
        if(getEverythingValidator.validate(input)) {
            // prepare the input
            String teamname = input.getTeamname();
            
            // call the database
            result.setTeam(DBTeamQueries.getTeam(teamname));
            result.setMember(DBUserTeamQueries.getActiveUserFromTeam(teamname));
            result.setTournaments(DBTeamTournamentQueries.getAllTournamentsFromTeam(teamname));
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
  
//##################################################
//# T E A M # S U C H E N ##########################
//##################################################    
// no validation needed, because there are no false inputs
    public SearchTeamResult searchTeam(SearchTeamInput input) {
        SearchTeamResult result = new SearchTeamResult();
     
        // prepare the input
        String team = input.getTeam();
        String tournament = input.getTournament();
        String user = input.getUser();

        // call the database
        if(team != null && !team.equals("")) 
            result.addTeam(DBTeamQueries.getTeam(team));
                
        if(tournament != null && !tournament.equals("")) 
            result.addTeams(DBTeamTournamentQueries.getAllTeamsFromTournament(tournament));
        
        if(user != null && !user.equals(""))
            result.addTeams(DBUserTeamQueries.getAllTeamsFromUser(user));
        
        // search after every team, if the user gives no input
        if(user != null && tournament != null && team != null) {
            if(user.equals("") && team.equals("") && tournament.equals(""))
                result.addTeams(DBTeamQueries.getAllTeams());
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    public EditTeamResult editTeam(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
     
        // prepare the input
        boolean query = false;
        
        if(editTeamValidator.validate(input)) {
            
            // call the database
            if(input.getKick_user() != null)
                query = DBUserTeamQueries.kickUser(input.getTeamname(), input.getKick_user());
            
            result.setQuerySuccessful(query);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }

//##################################################
//# T E A M N A M E N # Ä N D E R N ################
//##################################################
    public EditTeamResult changeName(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
        boolean query = false;
        
        if(editTeamValidator.validate_changeName(input)) {
            query = DBTeamQueries.editName(input.getTeamname(), input.getNew_name());
            result.setQuerySuccessful(query);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
//##################################################
//# T E A M T A G # Ä N D E R N ####################
//##################################################
    public EditTeamResult changeTag(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
        boolean query = false;
        
        query = DBTeamQueries.editTag(input.getTeamname(), input.getNew_tag());
        result.setQuerySuccessful(query);
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }    
    
//##################################################
//# P A S S W O R T # Ä N D E R N ##################
//##################################################
    public EditTeamResult changePassword(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
        boolean query = false;
        
        if(editTeamValidator.validate_changePassword(input)) {
            query = DBTeamQueries.editPassword(input.getTeamname(), input.getNew_password()); 
        }
        
        result.setQuerySuccessful(query);
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
//##################################################
//# T E A M L E I T E R # Ä N D E R N ##############
//##################################################
    public EditTeamResult changeLeader(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
        boolean query = false;
        
        if(editTeamValidator.validate_changeLeader(input)) {
            query = DBTeamQueries.editLeader(input.getTeamname(), input.getNew_leader());
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }     
    
//##################################################
//# T U R N I E R # V E R L A S S E N ##############
//##################################################
    public EditTeamResult leaveTournament(EditTeamInput input) {
        EditTeamResult result = new EditTeamResult();
        boolean query = false;
        
        if(editTeamValidator.validate_leaveTournament(input)) {
            query = DBTeamTournamentQueries.removeTeam(input.getLeave_tournament(), input.getTeamname());
            result.setQuerySuccessful(query);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }    
    
//##################################################
//# T E A M # L Ö S C H E N ########################
//##################################################    
    public BaseResult deleteTeam(String team, String password) {
        BaseResult result = new BaseResult();
        
        boolean query = false;
        
        return result;
    }
    
        
}

