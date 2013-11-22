package com.kmitsystem.services.team.input;

/**
 * @author Maik
 */
public class EditTeamInput {
    
    private String teamname;
    private String old_password;
    private String new_name;
    private String new_tag;
    private String new_password;
    private String new_leader;

    public EditTeamInput(String teamname, String old_password, String new_name, String new_tag, String new_password, String new_leader) {
        this.teamname = teamname;
        this.old_password = old_password;
        this.new_name = new_name;
        this.new_tag = new_tag;
        this.new_password = new_password;
        this.new_leader = new_leader;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_name() {
        return new_name;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }

    public String getNew_tag() {
        return new_tag;
    }

    public void setNew_tag(String new_tag) {
        this.new_tag = new_tag;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getNew_leader() {
        return new_leader;
    }

    public void setNew_leader(String new_leader) {
        this.new_leader = new_leader;
    }
    
            
}