package com.kmitsystem.services.team.input;

/**
 * @author Maik
 */
public class SearchTeamInput {
    
    private String team_name;
    private String tournament_name;
    private String user_name;

    public SearchTeamInput() {
        super();
    }

    public SearchTeamInput(String team_name, String tournament_name, String user_name) {
        super();
        this.team_name = team_name;
        this.tournament_name = tournament_name;
        this.user_name = user_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "SearchTeamInput{" + "team_name=" + team_name + ", tournament_name=" + tournament_name + ", user_name=" + user_name + '}';
    }
    
    
}
