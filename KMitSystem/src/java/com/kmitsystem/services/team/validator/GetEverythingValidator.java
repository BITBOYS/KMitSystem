package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.GetEverythingInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class GetEverythingValidator {
    
    public boolean validate(GetEverythingInput input) {
        
        // checks if the team is existing
        if(!DBTeamQueries.isTeamExisiting(input.getTeamname())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, GetEverythingValidator.class.getName() + ":isTeamExisting");
            return false;
        }
        
        return true;
    }
    
}
