package com.kmitsystem.services.team.input;

import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;

/**
 * @author Maik
 */
public class TeamInput {
    private User user;
    private Team team; 

    public TeamInput() {
        super();
    }

    public TeamInput(Team team) {
        this.team = team;
    }
    
    public TeamInput(User user, Team team) {
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
