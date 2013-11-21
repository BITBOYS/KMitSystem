package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
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
        
        return result;
    }
    
}

