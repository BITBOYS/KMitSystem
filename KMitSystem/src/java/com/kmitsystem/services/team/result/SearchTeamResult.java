package com.kmitsystem.services.team.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
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
        this.teams = teams;
    }
    
    public void addTeams(List<Team> teams) {
        for(int idx = 0; idx < teams.size(); idx++) {
            this.teams.add(teams.get(idx));
        }
    }

    @Override
    public String toString() {
        return "SearchTeamResult{" + "teams=" + teams + '}';
    }
    
    
}
