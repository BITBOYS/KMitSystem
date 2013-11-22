/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.UserServiceProvider;
import com.kmitsystem.services.user.input.ChangeUserEMailInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import java.util.ArrayList;
import java.util.List;

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
        
        if (input.getNewEmail1().equals(input.getNewEmail2()) == false) {
            
            ErrorHandler.handle(Errors.EMAILS_NOT_EQUAL);
            return false;
        }
        
        return true;        
    }
}
