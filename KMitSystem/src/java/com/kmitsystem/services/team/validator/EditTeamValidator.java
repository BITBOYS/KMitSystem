package com.kmitsystem.services.team.validator;

import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.tools.PasswordPolicy;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.database.queries.DBUserTeamQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 * @author Maik
 */
public class EditTeamValidator {
    
    public boolean validate(EditTeamInput input) {
        boolean result = true;
        
        if(input.getKick_user() != null) {
            if(DBTeamQueries.getTeam(input.getTeamname()).getLeader().getUsername().equals(input.getKick_user())) {
                ErrorHandler.handle(Errors.USER_IS_TEAMLEADER, EditTeamValidator.class.getName() + ":checkTeamMembership");
                return false;
            }
        }
        
        return result;
    }
    
//##################################################
//# T E A M N A M E N # Ä N D E R N ################
//##################################################    
    public boolean validate_changeName(EditTeamInput input) {
        boolean result = true;
        
        if(DBTeamQueries.isTeamExisiting(input.getNew_name())) {
            ErrorHandler.handle(Errors.NAME_ALREADY_TAKEN_ERROR, EditTeamValidator.class.getName() + ":isTeamExisting");
            return false;
        }
        
        return result;
    }
    
//##################################################
//# P A S S W O R T # Ä N D E R N ##################
//##################################################    
    public boolean validate_changePassword(EditTeamInput input) {
        PasswordPolicy passwordPolicy = new PasswordPolicy();
        boolean result = true;
        
        if(passwordPolicy.CheckPassword(input.getNew_password()) == false){
            ErrorHandler.handle(Errors.PASSWORD_NOT_VALID);
            return false;
        }
        
        return result;
    }    
    
//##################################################
//# T E A M L E I T E R # Ä N D E R N ##############
//##################################################    
    public boolean validate_changeLeader(EditTeamInput input) {
        boolean result = true;
        
        if(!DBUserQueries.isUsernameExisting(input.getNew_leader())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":changeLeader");
            return false;
        }
        
        if(!DBUserTeamQueries.checkTeamMembership(input.getNew_leader(), input.getTeamname())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":changeLeader");
            return false;
        }
        
        return result;
    }
    
//##################################################
//# T U R N I E R # V E R L A S S E N ##############
//##################################################    
    public boolean validate_leaveTournament(EditTeamInput input) {
        boolean result = true;
        
        if(!DBTournamentQueries.isTournamentExisting(input.getLeave_tournament())) {
            ErrorHandler.handle(Errors.TOURNAMENT_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":leaveTournament");
            return false;
        }
        
        if(!DBTeamQueries.isTeamExisiting(input.getTeamname())) {
            ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, EditTeamValidator.class.getName() + ":leaveTournament");
            return false;
        }
        
        if(!DBTeamTournamentQueries.checkTournamentMembership(input.getTeamname(), input.getLeave_tournament())) {
            ErrorHandler.handle(Errors.TEAM_NOT_IN_TOURNAMENT, EditTeamValidator.class.getName() + ":leaveTournament");
            return false;
        }
        
        return result;
    }   
    
}

