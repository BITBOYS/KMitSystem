package com.kmitsystem.tools.objects;

/**
 * @author Maik
 */
public class User {
    
    private String username;
    private String email;
    private String password;
    private Statistics statistics;

    public User() {
        super();
    }

    public User(String username) {
        this.username = username;
    }

    public User(String email, String password) {
        this.email = email;
        this.username = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, Statistics statistics) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.statistics = statistics;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    
}
