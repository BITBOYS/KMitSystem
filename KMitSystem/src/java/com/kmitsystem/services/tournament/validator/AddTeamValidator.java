package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.AddTeamInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class AddTeamValidator {
    
    public boolean validate(AddTeamInput input) {
        
        // check if the team exists
        if(!DBTeamQueries.isTeamExisiting(input.getTeamname())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, AddTeamValidator.class.getSimpleName() + ":isTeamExisting");
            return false;
        }
        
        // check if the tournament exists
        if(!DBTournamentQueries.isTournamentExisiting(input.getTeamname())) {
            ErrorHandler.handle(Errors.TOURNAMENT_DOES_NOT_EXIST, AddTeamValidator.class.getSimpleName() + ":isTournamentExisting");
            return false;
        }
        
        // check if the team is already in the tournament
        if(DBTeamTournamentQueries.checkTournamentMembership(input.getTeamname(), input.getTournamentname())) {
            ErrorHandler.handle(Errors.TEAM_ALREADY_IN_TOURNAMENT, AddTeamValidator.class.getSimpleName() + ":isTeamMember");
            return false;
        }
               
        return true;
    }
    
}
