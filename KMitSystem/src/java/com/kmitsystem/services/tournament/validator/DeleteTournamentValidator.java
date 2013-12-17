
package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.DeleteTournamentInput;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Malte
 */
public class DeleteTournamentValidator {
    
    public boolean validate(DeleteTournamentInput input){
        
        // check if a tournament with that name exists
        if(!DBTournamentQueries.isTournamentExisting(input.getTournamentToDelete())) {
            ErrorHandler.handle(Errors.TOURNAMENT_DOES_NOT_EXIST, DBTournamentQueries.class.getName() + ":isInvalidName");
            return false;
        }
        return true;
    }
    
}
