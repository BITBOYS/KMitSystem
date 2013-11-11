package com.kmitsystem.services.user.writeUserDataService.input;

import com.kmitsystem.tools.objects.User;


/**
 * @author Alex
 */
public class CreateUserInput {
    
    private String name;    
    private String password;
    private String email;
    private int goals;
    private int goals_conceded;
    private int wins;
    private int defeats;

    public CreateUserInput(String name, String password, String email, int goals, int goals_conceded, int wins, int defeats) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.goals = goals;
        this.goals_conceded = goals_conceded;
        this.wins = wins;
        this.defeats = defeats;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
