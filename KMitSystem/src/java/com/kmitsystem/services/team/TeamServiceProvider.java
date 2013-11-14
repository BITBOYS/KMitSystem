package com.kmitsystem.services.team;

import com.kmitsystem.services.team.input.AddPlayerInput;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.services.team.validator.AddPlayerValidator;
import com.kmitsystem.services.team.validator.CreateTeamValidator;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 * @author Maik
 */
public class TeamServiceProvider {
    
    CreateTeamValidator createTeamValidator = new CreateTeamValidator();
    AddPlayerValidator addPlayerValidator = new AddPlayerValidator();
    
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
    
    
        
}

