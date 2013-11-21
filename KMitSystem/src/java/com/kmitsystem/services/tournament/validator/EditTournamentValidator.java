package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class EditTournamentValidator {
    
    public boolean validate(EditTournamentInput input) {
        boolean result = true;
        
        if(input.getNew_name() != null) {
            if(DBTournamentQueries.isTournamentExisiting(input.getNew_name())) {
                ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, EditTournamentValidator.class.getName() + ":isTournamentExisting");
                return false;
            }
        }        
        
        return result;
    }
    
}

