package com.kmitsystem.services.team.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maik
 */
public class SearchTeamResult extends BaseResult{
    
    private List<Team> teams;
    
    public SearchTeamResult() {
        super();
    }

    public SearchTeamResult(List<Team> teams) {
        super();
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        if(this.teams == null)
            this.teams = new ArrayList<Team>();
        
        this.teams = teams;
    }
    
    public void addTeams(List<Team> teams) {
        if(this.teams == null)
            this.teams = new ArrayList<Team>();
            
        for(int idx = 0; idx < teams.size(); idx++) {
            getTeams().add(teams.get(idx));
        }
    }
    
    public void addTeam(Team team) {
        if(this.teams == null)
            this.teams = new ArrayList<Team>();
        
        if(team != null)
            this.teams.add(team);
    }

    @Override
    public String toString() {
        return "SearchTeamResult{" + "teams=" + teams + '}';
    }
    
    
}
