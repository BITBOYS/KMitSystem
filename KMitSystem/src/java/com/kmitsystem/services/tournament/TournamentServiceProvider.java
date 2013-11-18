package com.kmitsystem.services.tournament;

import com.kmitsystem.services.team.input.AddPlayerInput;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.services.team.input.SearchTeamInput;
import com.kmitsystem.services.team.result.GetEverythingResult;
import com.kmitsystem.services.team.result.SearchTeamResult;
import com.kmitsystem.services.team.validator.AddPlayerValidator;
import com.kmitsystem.services.team.validator.CreateTeamValidator;
import com.kmitsystem.services.team.validator.GetEverythingValidator;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 * @author Malte
 */
public class TournamentServiceProvider {
    
    CreateTeamValidator createTeamValidator = new CreateTeamValidator();
    AddPlayerValidator addPlayerValidator = new AddPlayerValidator();
    GetEverythingValidator getEverythingValidator = new GetEverythingValidator();
    
    public BaseResult createTeam(CreateTeamInput input) {
        BaseResult result = new BaseResult();

        if(createTeamValidator.validate(input)) {
            // prepare the input
            String name = input.getName();
            String tag = input.getTag();
            String password = input.getTag();
            User leader = input.getLeader();
            
            // call the database
            DBTeamQueries.createTeam(name, tag, password, leader);
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
        String team_name = input.getTeam();
        String tournament_name = input.getTournament();
        String user_name = input.getUser();

        // call the database
        if(team_name != null && !team_name.equals(""))
            result.getTeams().add(DBTeamQueries.getTeam(team_name));
        
        if(tournament_name != null && !tournament_name.equals("")) 
            result.addTeams(DBTeamTournamentQueries.getAllTeamsFromTournament(tournament_name));
        
        if(user_name != null && !user_name.equals(""))
            result.addTeams(DBUserTeamQueries.getAllTeamsFromUser(user_name));
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    
        
}

