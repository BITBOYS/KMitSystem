
package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Malte
 */
public class KickTeamValidator {
    
    public boolean validate(EditTournamentInput input) {
        
        // check if the team exists
        if(!DBTeamQueries.isTeamExisiting(input.getKick_team())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, KickTeamValidator.class.getSimpleName() + ":isTeamExisting");
            return false;
        }
        
        // check if the tournament exists
        if(!DBTournamentQueries.isTournamentExisting(input.getTournamentname())) {
            ErrorHandler.handle(Errors.TOURNAMENT_DOES_NOT_EXIST, KickTeamValidator.class.getSimpleName() + ":isTournamentExisting");
            return false;
        }
                       
        return true;
    }
}
