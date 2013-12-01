package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.tools.PasswordPolicy;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class EditTeamValidator {
    
    public boolean validate(EditTeamInput input) {
        PasswordPolicy passwordPolicy = new PasswordPolicy();
        boolean result = true;
        
        if(input.getNew_name() != null) {
            if(DBTeamQueries.isTeamExisiting(input.getNew_name())) {
                ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, EditTeamValidator.class.getName() + ":isTeamExisting");
                return false;
            }
        }
        
        if(input.getNew_password() != null && input.getNew_password().length() > 0) {
            if(passwordPolicy.CheckPassword(input.getNew_password()) == false){
                ErrorHandler.handle(Errors.PASSWORD_NOT_VALID);
                return false;
            }
        }
        
        if(input.getNew_leader() != null) {
            if(!DBUserQueries.isUsernameExisting(input.getNew_leader())) {
                ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":isUserExisting");
                return false;
            }
        }
        
        if(input.getKick_user() != null) {
            if(DBTeamQueries.getTeam(input.getTeamname()).getLeader().getUsername().equals(input.getKick_user())) {
                ErrorHandler.handle(Errors.USER_IS_TEAMLEADER, EditTeamValidator.class.getName() + ":checkTeamMembership");
                return false;
            }
        }
        
        return result;
    }
    
}

