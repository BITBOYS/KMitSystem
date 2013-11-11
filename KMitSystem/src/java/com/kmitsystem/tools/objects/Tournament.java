package com.kmitsystem.tools.objects;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Malte
 */
public class Tournament {
    
//    @TODO
    
//    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//    Date start_date = new Date();
//    Date end_date = new Date();    
    
    private String name;
    private String password;
    private User leader;
    private SimpleDateFormat start_date;
    private SimpleDateFormat end_date;
    private int nr_matchdays;
    
    public Tournament() {
        super();
    }

    public Tournament(String name, User leader) {
        this.name = name;
        this.leader = leader;
    }
    
    public Tournament(String name, String password, User leader) {
        this.name = name;
        this.password = password;
        this.leader = leader;
    }
    
    public Tournament(String name, SimpleDateFormat start_date, String password, User leader) {
        this.name = name;
        this.password = password;
        this.leader = leader;
        this.start_date = start_date;
    }

    public Tournament(String name, SimpleDateFormat start_date, String password, User leader, SimpleDateFormat end_date) {
        this.name = name;
        this.password = password;
        this.leader = leader;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public SimpleDateFormat getStart_date() {
        return start_date;
    }
    
    public void getStart_date(SimpleDateFormat start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(SimpleDateFormat end_date) {
        this.end_date = end_date;
    }

    public void getEnd_date(SimpleDateFormat end_date) {
        this.end_date = end_date;
    }

    public int nr_matchdays() {
        return nr_matchdays;
    }

    public void setNr_matchdays(int nr_matchdays) {
        this.nr_matchdays = nr_matchdays;
    }

    @Override
    public String toString() {
        return "Tournament{" + "name=" + name + ", Startdatum=" + start_date + ", Enddatum=" + end_date + ", leader=" + leader + ", password=" + password + ", Spieltage=" + nr_matchdays + '}';
    }
    
}

