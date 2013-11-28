
package com.kmitsystem.tools.objects;

/**
 *
 * @author v094700
 */
public class Table {
    
    private int tournament_team_matches;
    private int tournament_team_wins;
    private int tournament_team_draws;
    private int tournament_team_defeats;
    private int tournament_team_points;
    private int tournament_team_goals;
    private int tournament_team_goals_conceded;
    
    public Table(){
        super();
    }

    public Table(int tournament_team_matches, int tournament_team_wins, int tournament_team_draws, int tournament_team_defeats, int tournament_team_points, int tournament_team_goals, int tournament_team_goals_conceded) {
        this.tournament_team_matches = tournament_team_matches;
        this.tournament_team_wins = tournament_team_wins;
        this.tournament_team_draws = tournament_team_draws;
        this.tournament_team_defeats = tournament_team_defeats;
        this.tournament_team_points = tournament_team_points;
        this.tournament_team_goals = tournament_team_goals;
        this.tournament_team_goals_conceded = tournament_team_goals_conceded;
    }

    public int getTournament_team_matches() {
        return tournament_team_matches;
    }

    public int getTournament_team_wins() {
        return tournament_team_wins;
    }

    public int getTournament_team_draws() {
        return tournament_team_draws;
    }

    public int getTournament_team_defeats() {
        return tournament_team_defeats;
    }

    public int getTournament_team_points() {
        return tournament_team_points;
    }

    public int getTournament_team_goals() {
        return tournament_team_goals;
    }

    public int getTournament_team_goals_conceded() {
        return tournament_team_goals_conceded;
    }

    public void setTournament_team_matches(int tournament_team_matches) {
        this.tournament_team_matches = tournament_team_matches;
    }

    public void setTournament_team_wins(int tournament_team_wins) {
        this.tournament_team_wins = tournament_team_wins;
    }

    public void setTournament_team_draws(int tournament_team_draws) {
        this.tournament_team_draws = tournament_team_draws;
    }

    public void setTournament_team_defeats(int tournament_team_defeats) {
        this.tournament_team_defeats = tournament_team_defeats;
    }

    public void setTournament_team_points(int tournament_team_points) {
        this.tournament_team_points = tournament_team_points;
    }

    public void setTournament_team_goals(int tournament_team_goals) {
        this.tournament_team_goals = tournament_team_goals;
    }

    public void setTournament_team_goals_conceded(int tournament_team_goals_conceded) {
        this.tournament_team_goals_conceded = tournament_team_goals_conceded;
    }

    @Override
    public String toString() {
        return "Table{" + "tournament_team_matches=" + tournament_team_matches + ", tournament_team_wins=" + tournament_team_wins + ", tournament_team_draws=" + tournament_team_draws + ", tournament_team_defeats=" + tournament_team_defeats + ", tournament_team_points=" + tournament_team_points + ", tournament_team_goals=" + tournament_team_goals + ", tournament_team_goals_conceded=" + tournament_team_goals_conceded + '}';
    }
    
        
}
