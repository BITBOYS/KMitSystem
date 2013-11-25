/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.ChangeUserEMailInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Oerlex
 */
public class ChangeUserEMailValidator {

    public boolean validate(ChangeUserEMailInput input) {

        if (DBUserQueries.isEMailExisting(input.getOldEmail()) == true && DBUserQueries.isEMailExisting(input.getNewEmail1()) == true) {

            ErrorHandler.handle(Errors.EMAIL_ALREADY_TAKEN_ERROR);
            return false;
        }
        
        return true;        
    }
}
