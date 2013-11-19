package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Tournament;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Malte
 */
public class SearchTournamentResult extends BaseResult{
    
    private List<Tournament> tournament;
    
    public SearchTournamentResult() {
        super();
    }

    public SearchTournamentResult(List<Tournament> tournament) {
        super();
        this.tournament = tournament;
    }

    public List<Tournament> getTournaments() {
        return tournament;
    }

    public void setTournaments(List<Tournament> tournament) {
        if(this.tournament == null)
            this.tournament = new ArrayList<Tournament>();
        
        this.tournament = tournament;
    }
    
    public void addTournaments(List<Tournament> tournament) {
        if(this.tournament == null)
            this.tournament = new ArrayList<Tournament>();
            
        for(int idx = 0; idx < tournament.size(); idx++) {
            getTournaments().add(tournament.get(idx));
        }
    }
    
    public void addTournament(Tournament tournament) {
        if(this.tournament == null)
            this.tournament = new ArrayList<Tournament>();
        
        if(tournament != null)
            this.tournament.add(tournament);
    }

    @Override
    public String toString() {
        return "SearchTeamResult{" + "tournaments=" + tournament + '}';
    }
    
    
}
