package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.tools.PasswordPolicy;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Malte
 */
public class EditTournamentValidator {
    PasswordPolicy passwordPolicy = new PasswordPolicy();
    public boolean validate(EditTournamentInput input) {
        boolean result = true;
        
        if(input.getNew_name() != null) {
            if(DBTournamentQueries.isTournamentExisting(input.getNew_name())) {
                ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, EditTournamentValidator.class.getName() + ":isTournamentExisting");
                return false;
            }
        }       
        
        if(passwordPolicy.CheckPassword(input.getNew_password()) == false){
            ErrorHandler.handle(Errors.PASSWORD_NOT_VALID);
            return false;
        }
        
        if(input.getNew_leader() != null) {
            if(!DBTournamentQueries.isTournamentExisting(input.getNew_leader())) {
                ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, EditTournamentValidator.class.getName() + ":isUserExisting");
                return false;
            }
        }
        
        return result;
    }
    
}

