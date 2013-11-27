package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class GetEverythingValidator {
    
    public boolean validate(GetEverythingInput input) {
        
        // checks if the tournament is existing
        if(!DBTournamentQueries.isTournamentExisting(input.getTournamentname())) {
            ErrorHandler.handle(Errors.TOURNAMENT_DOES_NOT_EXIST, GetEverythingValidator.class.getName() + ":isTournamentExisting");
            return false;
        }
        
        return true;
    }
    
}
