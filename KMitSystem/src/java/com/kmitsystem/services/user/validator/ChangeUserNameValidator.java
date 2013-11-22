/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.ChangeUserNameInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Oerlex
 */
public class ChangeUserNameValidator {
   public boolean validate(ChangeUserNameInput input) {
       
        if(input.getNewName1().equals(input.getNewName2()) == false)
        {
            ErrorHandler.handle(Errors.NAMES_NOT_EQUAL);
            return false;
        }
        
        // check if the username is already taken
        if(DBUserQueries.isUsernameExisting(input.getNewName1())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBUserQueries.class.getName() + ": isUsernameExisting");
            return false;
        }
        
        return true;
        
       
    }

}
