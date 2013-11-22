package com.kmitsystem.services.team;

import com.kmitsystem.services.team.input.AddPlayerInput;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.input.SearchTeamInput;
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
            result.setMember(DBUserTeamQueries.getAllUserFromTeam(teamname));
            result.setTournaments(DBTeamTournamentQueries.getAllTournamentsFromTeam(teamname));
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
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
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    public BaseResult editTeam(EditTeamInput input) {
        BaseResult result = new BaseResult();
     
        // prepare the input
        String teamname = input.getTeamname();
        
        if(editTeamValidator.validate(input)) {
            String new_name = input.getNew_name();
            String new_tag = input.getNew_tag();
            String new_password = input.getNew_password();
            String new_leader = input.getNew_leader();
            
            // call the database
            if(new_name != null) 
                DBTeamQueries.editName(teamname, new_name);
            if(new_tag != null)
                DBTeamQueries.editTag(teamname, new_tag);
            if(new_password != null)
                DBTeamQueries.editPassword(teamname, new_password);
            if(new_leader != null)
                DBTeamQueries.editLeader(teamname, new_leader);
            
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
        
}

