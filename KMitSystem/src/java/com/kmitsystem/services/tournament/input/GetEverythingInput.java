package com.kmitsystem.services.tournament.input;

/**
 * @author Malte
 */
public class GetEverythingInput {
    
    private String tournamentname;

    public GetEverythingInput(String tournamentname) {
        this.tournamentname = tournamentname;
    }

    public String getTeamname() {
        return tournamentname;
    }

    public void setTeamname(String tournamentname) {
        this.tournamentname = tournamentname;
    }   
}