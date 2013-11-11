package com.kmitsystem.services.user.writeUserDataService.validator;

import com.kmitsystem.services.user.writeUserDataService.input.CreateUserInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Alex
 */
public class CreateUserValidator {
    
    public boolean validate(CreateUserInput input) {
        boolean result = true;
        
        if(!isValidName(input.getName())) {
            result = false;
        }
        
        return result;
    }
    
    private boolean isValidName(String name) {
        boolean result = true;
        
        if(DBTeamQueries.isTeamExisiting(name)) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBTeamQueries.class.getSimpleName() + ":isValidName");
            result = false;
        }
        
        return result;
    }
    
} 
