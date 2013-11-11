package com.kmitsystem.services.team.writeTeamDataService.input;

import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Date;

/**
 * @author Maik
 */
public class AddPlayerInput {
    private User user;
    private Team team; 

    public AddPlayerInput(User user, Team team) {
        this.user = user;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    
}
