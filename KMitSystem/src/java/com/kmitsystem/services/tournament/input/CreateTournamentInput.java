package com.kmitsystem.services.tournament.input;

import com.kmitsystem.tools.objects.User;

/**
 * @author Malte
 */
public class CreateTournamentInput {
    
    private String name;
    private String tag;
    private String password;
    private User leader;

    public CreateTournamentInput(String name, String tag, String password, User leader) {
        this.name = name;
        this.tag = tag;
        this.password = password;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }
        
}
