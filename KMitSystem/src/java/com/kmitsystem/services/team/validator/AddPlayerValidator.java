package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.TeamInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class AddPlayerValidator {
    
    public boolean validate(TeamInput input) {
        
        // check if the team exists
        if(!DBTeamQueries.isTeamExisiting(input.getTeam().getName())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, AddPlayerValidator.class.getSimpleName());
            return false;
        }
        
        // check if the user exists
        if(!DBUserQueries.isEMailExisting(input.getUser()) &&
           !DBUserQueries.isUsernameExisting(input.getUser())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, AddPlayerValidator.class.getSimpleName());
            return false;
        }
        
        // check if the user is already in the team
        if(DBUserTeamQueries.checkTeamMembership(input.getUser(), input.getTeam())) {
            ErrorHandler.handle(Errors.USER_ALREADY_IN_TEAM, AddPlayerValidator.class.getSimpleName());
            return false;
        }
               
        return true;
    }
    
}
