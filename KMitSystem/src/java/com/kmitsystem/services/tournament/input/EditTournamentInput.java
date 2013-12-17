package com.kmitsystem.services.tournament.input;

import java.sql.Date;

/**
 * @author Malte
 */
public class EditTournamentInput {
    
    private String tournamentname;
    private String new_name;
    private String new_password;
    private String new_leader;
    private String new_venue;
    private int new_nr_matchdays;
    private Date new_start_date;
    private Date new_end_date;
    private Date new_term_of_application;
    private String kick_team;
    private String invite_team;

    
    public EditTournamentInput(String tournamentname, String new_name, String new_password, String new_leader, String new_venue, Integer new_nr_matchdays, Date new_start_date, Date new_end_date, Date new_term_of_application, String kick_team, String invite_team) {
        this.tournamentname = tournamentname;
        this.new_name = new_name;
        this.new_password = new_password;
        this.new_leader = new_leader;
        this.new_venue = new_venue;
        this.new_nr_matchdays = new_nr_matchdays;
        this.new_start_date = new_start_date;
        this.new_end_date = new_end_date;
        this.new_term_of_application = new_term_of_application;
        this.kick_team = kick_team;
        this.invite_team = invite_team;
    }
    

    public String getTournamentname() {
        return tournamentname;
    }

    public String getNew_name() {
        return new_name;
    }

    public String getNew_password() {
        return new_password;
    }

    public String getNew_leader() {
        return new_leader;
    }

    public String getNew_venue() {
        return new_venue;
    }

    public int getNew_nr_matchdays() {
        return new_nr_matchdays;
    }

    public Date getNew_start_date() {
        return new_start_date;
    }

    public Date getNew_end_date() {
        return new_end_date;
    }

    public Date getNew_term_of_application() {
        return new_term_of_application;
    }

    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public void setNew_leader(String new_leader) {
        this.new_leader = new_leader;
    }

    public void setNew_venue(String new_venue) {
        this.new_venue = new_venue;
    }

    public void setNew_nr_matchdays(int new_nr_matchdays) {
        this.new_nr_matchdays = new_nr_matchdays;
    }

    public void setNew_start_date(Date new_start_date) {
        this.new_start_date = new_start_date;
    }

    public void setNew_end_date(Date new_end_date) {
        this.new_end_date = new_end_date;
    }

    public void setNew_term_of_application(Date new_term_of_application) {
        this.new_term_of_application = new_term_of_application;
    }

    public String getKick_team() {
        return kick_team;
    }

    public String getInvite_team() {
        return invite_team;
    }

    public void setKick_team(String kick_team) {
        this.kick_team = kick_team;
    }

    public void setInvite_team(String invite_team) {
        this.invite_team = invite_team;
    }

    @Override
    public String toString() {
        return "EditTournamentInput{" + "tournamentname=" + tournamentname + ", new_name=" + new_name + ", new_password=" + new_password + ", new_leader=" + new_leader + ", new_venue=" + new_venue + ", new_nr_matchdays=" + new_nr_matchdays + ", new_start_date=" + new_start_date + ", new_end_date=" + new_end_date + ", new_term_of_application=" + new_term_of_application + ", kick_team=" + kick_team + ", invite_team=" + invite_team + '}';
    }

     
}