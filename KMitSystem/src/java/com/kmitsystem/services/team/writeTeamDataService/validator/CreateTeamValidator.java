package com.kmitsystem.services.team.writeTeamDataService.validator;

import com.kmitsystem.services.team.writeTeamDataService.input.CreateTeamInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.DatabaseTeamQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class CreateTeamValidator {
    
    public boolean validate(CreateTeamInput input) {
        boolean result = true;
        
        if(!isValidName(input.getName())) {
            result = false;
        }
        
        return result;
    }
    
    private boolean isValidName(String name) {
        boolean result = true;
        
        if(DatabaseTeamQueries.countTeams(name) > 0) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DatabaseTeamQueries.class.getSimpleName() + ":isValidName");
            result = false;
        }
        
        return result;
    }
    
} 
