package com.kmitsystem.tools.database.queries;

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
            resultSet = statement.executeQuery("select * from team where name=\"" + name + "\"");
            resultSet.first();
            
            String teamname = resultSet.getString("name");
            String tag = resultSet.getString("tag");
            User leader = new User();
            String password = resultSet.getString("password");
            Statistics statistics = new Statistics(resultSet.getInt("goals"), resultSet.getInt("goals_conceded"), resultSet.getInt("wins"), 
                    resultSet.getInt("defeats"), resultSet.getInt("tournament_wins"), resultSet.getInt("tournament_participations"));

            team = new Team(teamname, tag, password, leader, statistics);
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return team;
    }
    
    public static void createTeam(String name, String tag, String password, User leader) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            if(password.equals("")) { 
                statement.execute("insert into team"
                        + "(name, tag, leader)"
                        + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + leader.getUsername() + "\")");
            } else {
                statement.execute("insert into team"
                        + "(name, tag, password, leader)"
                        + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + password + "\",\"" + leader.getUsername() + "\")"); 
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
}