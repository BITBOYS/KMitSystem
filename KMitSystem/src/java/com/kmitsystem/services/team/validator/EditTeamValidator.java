package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class EditTeamValidator {
    
    public boolean validate(EditTeamInput input) {
        boolean result = true;
        
        if(input.getNew_name() != null) {
            if(DBTeamQueries.isTeamExisiting(input.getNew_name())) {
                ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, EditTeamValidator.class.getName() + ":isTeamExisting");
                return false;
            }
        }
        
        if(input.getOld_password() != null) {
            if(!DBTeamQueries.isTeamPasswordOK(input.getTeamname(), input.getNew_password())) {
                ErrorHandler.handle(Errors.PASSWORD_FALSE, EditTeamValidator.class.getName() + ":isTeamPasswordOK");
                return false;
            }
        }
        
        if(input.getNew_leader() != null) {
            if(!DBUserQueries.isUsernameExisting(input.getNew_leader())) {
                ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":isUserExisting");
                return false;
            }
        }
        
        return result;
    }
    
}

