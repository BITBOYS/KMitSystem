package com.kmitsystem.services.team.writeTeamDataService.validator;

import com.kmitsystem.services.team.writeTeamDataService.input.CreateTeamInput;
import com.kmitsystem.tools.database.DatabaseTeamQueries;

/**
 * @author Maik
 */
public class CreateTeamValidator {
    
    public boolean validate(CreateTeamInput input) {
        boolean result = true;
        
        if(!isValidName(input.getName())) {
            System.out.println("Team schon vorhanden!");
        }
        
        return result;
    }
    
    private boolean isValidName(String name) {
        boolean result = true;
        
        if(DatabaseTeamQueries.getTeam(name) != null)
            result = false;
        
        return result;
    }
    
} 
