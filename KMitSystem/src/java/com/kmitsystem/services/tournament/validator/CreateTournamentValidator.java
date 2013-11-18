package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.CreateTournamentInput;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class CreateTournamentValidator {
    
    public boolean validate(CreateTournamentInput input) {
        
        // check if a team with that name already exists
        if(DBTournamentQueries.isTournamentExisiting(input.getName())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, DBTournamentQueries.class.getName() + ":isValidName");
            return false;
        }
        
        // check if the leader exists
        if(!DBUserQueries.isEMailExisting(input.getLeader().getEmail()) &&
           !DBUserQueries.isUsernameExisting(input.getLeader().getUsername())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, CreateTournamentValidator.class.getSimpleName());
            return false;
        }
        
        return true;
    }
    
} 
