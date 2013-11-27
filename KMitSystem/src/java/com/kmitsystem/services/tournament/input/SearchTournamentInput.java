package com.kmitsystem.services.tournament.input;

/**
 * @author Malte
 */
public class SearchTournamentInput {
    
    private String team;
    private String tournament;
    private String user;
    private String create_month;
    Boolean tournament_running;
    Boolean tournament_finished;

    public SearchTournamentInput() {
        super();
    }
    
    public SearchTournamentInput(String team, String tournament, String user) {
        super();
        this.team = team;
        this.tournament = tournament;
        this.user = user;
    }

    public SearchTournamentInput(String team, String tournament, String user, String create_month) {
        super();
        this.team = team;
        this.tournament = tournament;
        this.user = user;
        this.create_month = create_month;
    }

    public SearchTournamentInput(String team, String tournament, String user, String create_month, Boolean tournament_running, Boolean tournament_finished) {
        super();
        this.team = team;
        this.tournament = tournament;
        this.user = user;
        this.create_month = create_month;
        this.tournament_running = tournament_running;
        this.tournament_finished = tournament_finished;
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
    
    public String getCreateMonth() {
        return create_month;
    }

    public void setCreateMonth(String create_month) {
        this.create_month = create_month;
    }
    
    public Boolean getTournamentIsRunning() {
        return tournament_running;
    }

    public void setTournamentIsRunning(Boolean tournament_running) {
        this.tournament_running = tournament_running;
    }
        
    public Boolean getTournamentIsFinished() {
        return tournament_finished;
    }

    public void setTournamentIsFinished(Boolean tournament_finished) {
        this.tournament_finished = tournament_finished;
    }

    @Override
    public String toString() {
        return "SearchTournamentInput{" + "team_name=" + team + ", tournament_name=" + tournament + ", user_name=" + user + ", create_month=" + create_month + ", tournament_running=" + tournament_running + ", tournament_finished=" + tournament_finished + '}';
    }
    
    
}
