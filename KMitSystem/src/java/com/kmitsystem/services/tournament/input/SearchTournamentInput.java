package com.kmitsystem.services.tournament.input;

/**
 * @author Malte
 */
public class SearchTournamentInput {
    
    private String team;
    private String tournament;
    private String user;
    String create_date;
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


    public SearchTournamentInput(String team, String tournament, String user, String create_date, Boolean tournament_running, Boolean tournament_finished) {
        super();
        this.team = team;
        this.tournament = tournament;
        this.user = user;
        this.create_date = create_date;
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
    
    public String getCreateDate() {
        return create_date;
    }

    public void setCreateDate(String create_date) {
        this.create_date = create_date;
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
        return "SearchTournamentInput{" + "team_name=" + team + ", tournament_name=" + tournament + ", user_name=" + user + ", create_date=" + create_date + ", tournament_running=" + tournament_running + ", tournament_finished=" + tournament_finished + '}';
    }
    
    
}
