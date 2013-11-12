package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.TeamInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class CreateTeamValidator {
    
    public boolean validate(TeamInput input) {
        
        // check if a team with that name already exists
        if(DBTeamQueries.isTeamExisiting(input.getTeam().getName())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBTeamQueries.class.getName() + ":isValidName");
            return false;
        }
        
        // check if the leader exists
        if(!DBUserQueries.isUserExisting(input.getTeam().getLeader())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, AddPlayerValidator.class.getSimpleName());
            return false;
        }
        
        return true;
    }
    
} 
