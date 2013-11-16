package com.kmitsystem.services.team.input;

/**
 * @author Smadback
 */
public class GetEverythingInput {
    
    private String teamname;

    public GetEverythingInput(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }   
}
