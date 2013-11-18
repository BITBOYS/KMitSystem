package com.kmitsystem.services.tournament.input;

/**
 * @author Malte
 */
public class AddTeamInput {
    
    private String tournamentname;
    private String teamname;

    public AddTeamInput(String tournamentname, String teamname) {
        this.tournamentname = tournamentname;
        this.teamname = teamname;
    }

    public String getTournamentname() {
        return tournamentname;
    }

    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
            
}
