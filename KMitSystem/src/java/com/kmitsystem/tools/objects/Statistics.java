package com.kmitsystem.tools.objects;

/**
 * @author Maik
 */
public class Statistics {
    
    private int goals;
    private int goals_conceded;
    private int wins;
    private int defeats;

    public Statistics() {
        super();
    }

    public Statistics(int goals, int goals_conceded, int wins, int defeats) {
        this.goals = goals;
        this.goals_conceded = goals_conceded;
        this.wins = wins;
        this.defeats = defeats;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals_conceded() {
        return goals_conceded;
    }

    public void setGoals_conceded(int goals_conceded) {
        this.goals_conceded = goals_conceded;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }
    
    
    
}
