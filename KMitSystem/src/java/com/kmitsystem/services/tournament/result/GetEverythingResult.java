
package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Malte
 */
public class GetEverythingResult extends BaseResult {
    
    private Tournament tournament = new Tournament();
    private List<Team> teams = new ArrayList<Team>();
    
    public GetEverythingResult() {
        super();
    }    

    public GetEverythingResult(Tournament tournament, List<Team> teams) {
        super();
        this.tournament = tournament;
        this.teams = teams;
    }
    
    public Tournament getTeam() {
        return tournament;
    }
    
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "GetEverythingResult{" +"tournament=" + tournament + ", teams=" + teams + '}';
    }
    
}
