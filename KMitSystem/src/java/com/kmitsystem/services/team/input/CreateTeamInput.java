package com.kmitsystem.services.team.input;

/**
 * @author Maik
 */
public class CreateTeamInput {
    
    private String name;
    private String tag;
    private String password;
    private String leader;

    public CreateTeamInput(String name, String tag, String password, String leader) {
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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
        
}
