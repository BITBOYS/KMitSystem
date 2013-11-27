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
    private String leave_tournament;
    private String kick_user;
    private String invite_user;

    public EditTeamInput(String teamname, String old_password, String new_name, 
                         String new_tag, String new_password, String new_leader, 
                         String leave_tournament, String kick_user, String invite_user) {
        this.teamname = teamname;
        this.old_password = old_password;
        this.new_name = new_name;
        this.new_tag = new_tag;
        this.new_password = new_password;
        this.new_leader = new_leader;
        this.leave_tournament = leave_tournament;
        this.kick_user = kick_user;
        this.invite_user = invite_user;
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

    public String getLeave_tournament() {
        return leave_tournament;
    }

    public void setLeave_tournament(String leave_tournament) {
        this.leave_tournament = leave_tournament;
    }

    public String getKick_user() {
        return kick_user;
    }

    public void setKick_user(String kick_user) {
        this.kick_user = kick_user;
    }

    public String getInvite_user() {
        return invite_user;
    }

    public void setInvite_user(String invite_user) {
        this.invite_user = invite_user;
    }
    
            
}