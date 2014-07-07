/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maik
 */
public class DBUserTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static void addPlayer(String username, String teamname) {
        try {        
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date enter_date = new Date();
            
            statement.execute("INSERT INTO user_team"
                    + "(user, team, enter_dat)"
                    + "VALUES ('" + username + "','" + teamname + "','" + formatter.format(enter_date) + "')");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static boolean kickUser(String teamname, String username) {
        try {        
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            int result = 0;
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date quit_date = new Date();
            
            result = statement.executeUpdate("UPDATE user_team "
                            + "SET quit_dat = '" + formatter.format(quit_date) + "' "
                            + "WHERE user = '" + username + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.KICK_USER_SUCCESSFUL, DBUserTeamQueries.class.getName() + ":kickUser");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean checkTeamMembership(String username, String teamname) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count "
                                    + " FROM user_team "
                                    + " WHERE user = '" + username + "'"
                                    + "   AND team = '" + teamname + "'");
            
            resultSet.first();
            
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
    public static List<User> getAllUserFromTeam(String teamname) {
        List<User> teammember = new ArrayList<User>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT username, email, password, goals,"
                                            + " goals_conceded, wins, defeats, tournament_wins, tournament_participations"
                                            + " FROM  user, user_team"
                                            + " WHERE team = '" + teamname + "'"
                                            + "   AND username = user" );
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                teammember.add(new User(resultSet.getString("username"), 
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        new Statistics(resultSet.getInt("goals"), 
                                                       resultSet.getInt("goals_conceded"), 
                                                       resultSet.getInt("wins"),
                                                       resultSet.getInt("defeats"),
                                                       resultSet.getInt("tournament_wins"),
                                                       resultSet.getInt("tournament_participations"))));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teammember;
    }
    
    public static List<User> getActiveUserFromTeam(String teamname) {
        List<User> teammember = new ArrayList<User>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT username, email, password, goals,"
                                            + " goals_conceded, wins, defeats, tournament_wins, tournament_participations"
                                            + " FROM  user, user_team"
                                            + " WHERE team = '" + teamname + "'"
                                            + " AND (quit_dat is NULL OR quit_dat = '')"
                                            + "   AND username = user" );
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                teammember.add(new User(resultSet.getString("username"), 
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        new Statistics(resultSet.getInt("goals"), 
                                                       resultSet.getInt("goals_conceded"), 
                                                       resultSet.getInt("wins"),
                                                       resultSet.getInt("defeats"),
                                                       resultSet.getInt("tournament_wins"),
                                                       resultSet.getInt("tournament_participations"))));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teammember;
    }
    
    public static List<Team> getAllTeamsFromUser(String username) {
        List<Team> teams = new ArrayList<Team>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT name, tag, password, create_date, leader, team.wins, team.defeats, "
                                                    + "team.goals, team.goals_conceded, team.tournament_wins, team.tournament_participations"
                                            + " FROM  team, user_team"
                                            + " WHERE user = '" + username + "'"
                                            + "   AND team = name" );
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                teams.add(new Team(resultSet.getString("name"), 
                                   resultSet.getString("tag"),
                                   resultSet.getString("password"), 
                                   new User(resultSet.getString("leader")), 
                                   new Statistics(resultSet.getInt("goals"), resultSet.getInt("goals_conceded"), 
                                                  resultSet.getInt("wins"), resultSet.getInt("defeats"), resultSet.getInt("tournament_wins"), 
                                                  resultSet.getInt("tournament_participations")), 
                                   resultSet.getDate("create_date")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teams;
    }

    
}
