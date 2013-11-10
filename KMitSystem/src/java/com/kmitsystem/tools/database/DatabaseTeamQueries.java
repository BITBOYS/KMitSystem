package com.kmitsystem.tools.database;

import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maik
 */
public class DatabaseTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static int countTeams(String name) {
        int teams = 0;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from team where name=\"" + name + "\"");
            resultSet.first();
            teams = resultSet.getInt("count");
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teams;
    }
    
    public static Team getTeam(String name) {
        Team team = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from team where name=\"" + name + "\"");
            
            if(resultSet.getFetchSize() != 0) {
                String teamname = resultSet.getString("name");
                String tag = resultSet.getString("tag");
                User leader = new User();
                String password = resultSet.getString("password");
                Statistics statistics = new Statistics();

                team = new Team(teamname, tag, password, leader, statistics);
                System.out.println(team.toString());
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return team;
    }
    
    public static void createTeam(Team team) {
        
        try {
            System.out.println("CREATE TEAMS");
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            String name = team.getName();
            String tag = team.getTag();
            String password = team.getPassword();
            String leader = team.getLeader().getUsername();
            
            if(password.equals("")) { 
                statement.execute("insert into team"
                        + "(name, tag, leader)"
                        + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + leader + "\")");
            } else {
                statement.execute("insert into team"
                        + "(name, tag, password, leader)"
                        + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + password + "\",\"" + leader + "\")"); 
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
}