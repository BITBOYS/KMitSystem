package com.kmitsystem.tools.objects;

import java.sql.Date;

/**
 * @author Maik
 */
public class User {
    
    private String username;
    private String email;
    private Date create_date;
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
        this.password = password;
    }

    public User(String username, String email, String password, Date create_date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.create_date = create_date;
    }

    public User(String username, String email, String password, Statistics statistics) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.statistics = statistics;
    }
    
    public User(String username, String email, String password, Statistics statistics, Date create_date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.statistics = statistics;
        this.create_date = create_date;
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

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", email=" + email + ", create_date=" + create_date + ", password=" + password + ", statistics=" + statistics + '}';
    }
    
}
