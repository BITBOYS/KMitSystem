package com.kmitsystem.services.team.input;

/**
 * @author Maik
 */
public class SearchTeamInput {
    
    private String team;
    private String tournament;
    private String user;

    public SearchTeamInput() {
        super();
    }

    public SearchTeamInput(String team, String tournament, String user) {
        super();
        this.team = team;
        this.tournament = tournament;
        this.user = user;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SearchTeamInput{" + "team_name=" + team + ", tournament_name=" + tournament + ", user_name=" + user + '}';
    }
    
    
}
