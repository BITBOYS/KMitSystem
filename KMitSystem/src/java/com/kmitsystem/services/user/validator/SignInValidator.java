/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.SignInInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Malte
 */
public class SignInValidator {
    
    public boolean validate(SignInInput input) {
        boolean result = true;
        
        // check if a user with this email is existing
        if(!DBUserQueries.isEMailExisting(input.getEmail())) {
            ErrorHandler.handle(Errors.FALSE_LOGIN_INPUT, DBUserQueries.class.getName() + ":isEMailExisting");
            return false;
        }
        
        // check if the password is right
        if(!DBUserQueries.userPasswordOk(input.getEmail(), input.getPassword())) {
            ErrorHandler.handle(Errors.FALSE_LOGIN_INPUT, DBUserQueries.class.getName() + ":userPasswordOk");
            return false;
        }
        
        return result;
    }
}
