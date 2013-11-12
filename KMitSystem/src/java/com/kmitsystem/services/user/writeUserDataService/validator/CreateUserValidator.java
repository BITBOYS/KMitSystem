package com.kmitsystem.services.user.writeUserDataService.validator;

import com.kmitsystem.services.user.writeUserDataService.input.CreateUserInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Alex, Malte
 */
public class CreateUserValidator {
    
    public boolean validate(CreateUserInput input) {
        boolean result = true;
        
        if(!isValidName(input.getName()) && !isValidEmail(input.getName())) {
            result = false;
        }
        
        return result;
    }
    
    private boolean isValidName(String name) {
        boolean result = true;
        
        if(DBUserQueries.isUserExisiting(name)) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBUserQueries.class.getSimpleName() + ":isValidName");
            result = false;
        }
        
        return result;
    }
    
    private boolean isValidEmail(String email) {
        boolean result = true;
        
        if(DBUserQueries.isUserExisiting(email)) {
            ErrorHandler.handle(Errors.EMAIL_ALREADY_TAKEN_ERROR, DBUserQueries.class.getSimpleName() + ":isValidEmail");
            result = false;
        }
        
        return result;
    }
    
} 
