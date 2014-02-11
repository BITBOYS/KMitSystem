package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Tournament;
import java.util.ArrayList;

/**
 * @author Malte
 */
public class SearchTournamentResult extends BaseResult {

    private ArrayList<Tournament> tournaments;

    public SearchTournamentResult() {
        super();
    }

    public SearchTournamentResult(ArrayList<Tournament> tournament) {
        super();
        this.tournaments = tournament;
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(ArrayList<Tournament> tournament) {
        if (this.tournaments == null) {
            this.tournaments = new ArrayList<Tournament>();
        }

        this.tournaments = tournament;
    }

    public void addTournaments(ArrayList<Tournament> tournament) {
        if (this.tournaments == null) {
            this.tournaments = new ArrayList<Tournament>();
        }

//        if (!tournaments.contains(tournament)) {
            for (int idx = 0; idx < tournament.size(); idx++) {
                getTournaments().add(tournament.get(idx));
            }
//        }
    }

    public void addTournament(Tournament tournament) {
        if (this.tournaments == null) {
            this.tournaments = new ArrayList<Tournament>();
        }
//        if (!tournaments.contains(tournament)) {
            if (tournament != null) {
                this.tournaments.add(tournament);
            }
//        }
    }

    @Override
    public String toString() {
        return "SearchTeamResult{" + "tournaments=" + tournaments + '}';
    }

}
