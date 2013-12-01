package com.kmitsystem.services.user.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.util.List;

/**
 * @author Smadback
 */
public class GetEverythingResult extends BaseResult{
    
    User user;
    List<Team> teams;
    List<Tournament> tournaments;

    public GetEverythingResult() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
    
       
}
