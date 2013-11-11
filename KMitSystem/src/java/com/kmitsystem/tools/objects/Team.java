package com.kmitsystem.tools.objects;

/**
 * @author Maik
 */
public class Team {
    
    private String name;
    private String tag;
    private User leader;
    private String password;
    private Statistics statistics;
    
    public Team() {
        super();
    }

    public Team(String name, String tag, User leader) {
        this.name = name;
        this.tag = tag;
        this.leader = leader;
    }
    
    public Team(String name, String tag, String password, User leader) {
        this.name = name;
        this.tag = tag;
        this.password = password;
        this.leader = leader;
    }

    public Team(String name, String tag, String password, User leader, Statistics statistics) {
        this.name = name;
        this.tag = tag;
        this.password = password;
        this.leader = leader;
        this.statistics = statistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
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

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", tag=" + tag + ", leader=" + leader + ", password=" + password + ", statistics=" + statistics + '}';
    }
    
}
