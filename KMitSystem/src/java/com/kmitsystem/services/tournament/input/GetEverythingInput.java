package com.kmitsystem.services.tournament.input;

/**
 * @author Malte
 */
public class GetEverythingInput {
    
    private String tournamentname;

    public GetEverythingInput(String tournamentname) {
        this.tournamentname = tournamentname;
    }

    public String getTournamentname() {
        return tournamentname;
    }

    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
    }   
}