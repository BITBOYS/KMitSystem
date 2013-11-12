/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.services.user.readUserDataService.validator;

import com.kmitsystem.services.user.readUserDataService.input.ReadUserDataInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Malte
 */
public class ReadUserValidator {
    
    public boolean validate(ReadUserDataInput input) {
        boolean result = true;
        
        if(!isValidEmail(input.getUser().getEmail())) {
            result = false;
        }
        
        return result;
    }
    
//    private boolean isValidName(String name) {
//        boolean result = true;
//        
//        if(DBTeamQueries.isTeamExisiting(name)) {
//            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBTeamQueries.class.getSimpleName() + ":isValidName");
//            result = false;
//        }
//        
//        return result;
//    }
    
    private boolean isValidEmail(String email) {
        boolean result = true;
        
        if(DBUserQueries.isUserExisiting(email)) {
            ErrorHandler.handle(Errors.EMAIL_ALREADY_TAKEN_ERROR, DBUserQueries.class.getSimpleName() + ":isValidEmail");
            result = false;
        }
        
        return result;
    }
}
