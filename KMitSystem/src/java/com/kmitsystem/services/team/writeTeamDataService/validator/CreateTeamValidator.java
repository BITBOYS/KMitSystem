package com.kmitsystem.services.team.writeTeamDataService.validator;

import com.kmitsystem.services.team.writeTeamDataService.input.CreateTeamInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class CreateTeamValidator {
    
    public boolean validate(CreateTeamInput input) {
        boolean result = true;
        
        // check if a team with that name already exists
        if(DBTeamQueries.isTeamExisiting(input.getName())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBTeamQueries.class.getSimpleName() + ":isValidName");
            result = false;
        }
        
        return result;
    }
    
} 
