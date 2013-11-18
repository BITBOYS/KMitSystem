package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.team.input.AddPlayerInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class AddTeamValidator {
    
    public boolean validate(AddPlayerInput input) {
        
        // check if the team exists
        if(!DBTeamQueries.isTeamExisiting(input.getTeamname())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, AddTeamValidator.class.getSimpleName());
            return false;
        }
        
        // check if the user exists
        if(!DBUserQueries.isUsernameExisting(input.getUsername())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, AddTeamValidator.class.getSimpleName());
            return false;
        }
        
        // check if the user is already in the team
        if(DBUserTeamQueries.checkTeamMembership(input.getUsername(), input.getTeamname())) {
            ErrorHandler.handle(Errors.USER_ALREADY_IN_TEAM, AddTeamValidator.class.getSimpleName());
            return false;
        }
               
        return true;
    }
    
}
