/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.team.input;

/**
 * @author v094702
 */
public class AddPlayerInput {
    
    private String username;
    private String teamname;

    public AddPlayerInput(String username, String teamname) {
        this.username = username;
        this.teamname = teamname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }
            
}
