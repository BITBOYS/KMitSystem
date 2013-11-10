package com.kmitsystem.services.team.writeTeamDataService;

import com.kmitsystem.services.team.writeTeamDataService.input.CreateTeamInput;
import com.kmitsystem.services.team.writeTeamDataService.validator.CreateTeamValidator;
import com.kmitsystem.tools.database.DatabaseTeamQueries;
import com.kmitsystem.tools.objects.Team;

/**
 * @author Maik
 */
public class WriteTeamDataServiceProvider {
    
    CreateTeamValidator createTeamValidator = new CreateTeamValidator();
    
    public void createTeam(CreateTeamInput input) {
        
        if(createTeamValidator.validate(input)) {
            // prepare the input
            Team team = new Team(input.getName(), input.getTag(), input.getPassword(), input.getLeader());
            
            // call the database
            DatabaseTeamQueries.createTeam(team);
        }
    }
}
