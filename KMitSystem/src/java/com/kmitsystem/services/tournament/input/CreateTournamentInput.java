package com.kmitsystem.services.tournament.input;

import com.kmitsystem.tools.DateKonverter;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Date;
import java.util.List;


/**
 * @author Malte
 */
public class CreateTournamentInput {
    
    private String name;
    private String password;
    private String description;
    private User leader;
    private String start_date;
    private String end_date;
    private String nr_matchdays;
    private String venue;
    private String term_of_application;
//    private List<Team> teams;
    
    public CreateTournamentInput() {
        super();
    }

    public CreateTournamentInput(String name, String password, String description, User leader, String start_date, String end_date, 
                    String nr_matchdays, String venue, String term_of_application) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.leader = leader;
        this.start_date = start_date;
        this.end_date = end_date;
        this.nr_matchdays = nr_matchdays;
        this.venue = venue;
        this.term_of_application = term_of_application;
//        this.teams = teams;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }
    
    public Date getStart_date() {
        return Date.valueOf(start_date);
    }
    
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return Date.valueOf(end_date);
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getNr_matchdays() {
        return Integer.parseInt(nr_matchdays);
    }

    public void setNr_matchdays(String nr_matchdays) {
        this.nr_matchdays = nr_matchdays;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getTerm_of_application() {
        return Date.valueOf(term_of_application);
    }

    public void setTerm_of_application(String term_of_application) {
        this.term_of_application = term_of_application;
    }

//    public List<Team> getTeams() {
//        return teams;
//    }
//
//    public void setTeams(List<Team> teams) {
//        this.teams = teams;
//    }

    @Override
    public String toString() {
        return "CreateTournamentInput{" + "name=" + name + ", password=" + password + ", description=" + description + ", leader=" + leader + ", start_date=" + start_date + ", end_date=" + end_date + ", nr_matchdays=" + nr_matchdays + ", venue=" + venue + ", term_of_application=" + term_of_application ;
    }
    
}
