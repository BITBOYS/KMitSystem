package com.kmitsystem.tools.database.queries;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.tools.database.DatabaseHandler;
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
public class DBTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static boolean isTeamExisiting(String name) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from team where name=\"" + name + "\"");
            resultSet.first();
            
            if(resultSet.getInt("count") > 0) 
                result = true;
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
    public static Team getTeam(String name) {
        Team team = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from team where name='" + name + "'");
            resultSet.first();
            
            String teamname = resultSet.getString("name");
            String tag = resultSet.getString("tag");
            User leader = new User(resultSet.getString("leader"));
            String password = resultSet.getString("password");
            Statistics statistics = new Statistics(resultSet.getInt("goals"), resultSet.getInt("goals_conceded"), resultSet.getInt("wins"), 
                    resultSet.getInt("defeats"), resultSet.getInt("tournament_wins"), resultSet.getInt("tournament_participations"));

            team = new Team(teamname, tag, password, leader, statistics);
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        return team;
    }
    
    public static void createTeam(String name, String tag, String password, String leader) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            statement.execute("insert into team"
                        + "(name, tag, password, leader)"
                        + "VALUES ('" + name + "','" + tag + "','" + password + "','" + leader + "')");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static void editName(String teamname, String new_name) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET name = '" + new_name + "' WHERE name = '" + teamname + "'");
            
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, TeamServiceProvider.class.getName() + ":editName");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamname: " + ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static void editTag(String teamname, String new_tag) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET tag = '" + new_tag + "' WHERE name = '" + teamname + "'");
            
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, TeamServiceProvider.class.getName() + ":editTag");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamTag: " + ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static void editPassword(String teamname, String new_password) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET password = '" + new_password + "' WHERE name = '" + teamname + "'");
            
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, TeamServiceProvider.class.getName() + ":editPassword");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTeamPassword: " + ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static void editLeader(String teamname, String new_leader) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            // create the team
            result = statement.executeUpdate("UPDATE team SET leader = '" + new_leader + "' WHERE name = '" + teamname + "'");
            
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, TeamServiceProvider.class.getName() + ":editLeader");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editLeader: " + ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static Boolean isTeamPasswordOK(String teamname, String password) {
        
        Boolean result = false;
        
         try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count "
                                        + "from team "
                                        + "where name='" + teamname + "'"
                                        + "and password='" + password + "'");
            
            resultSet.first();
           
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "isTeamPasswordOK: " + ex.getSQLState() + " " +ex.getMessage());
        }
        
         return result;
    }
    
}