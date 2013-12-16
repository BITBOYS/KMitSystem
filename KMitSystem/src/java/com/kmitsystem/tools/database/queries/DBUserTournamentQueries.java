package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Malte
 */
public class DBUserTournamentQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static List<User> getAllUserFromTournament(String tournamentname) {
        List<User> member = new ArrayList<User>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            //TODO
            resultSet = statement.executeQuery("SELECT username, u.password, u.email, u.create_date, u.goals,  u.goals_conceded, u.wins, u.defeats, u.goals_conceded"
                                            + " FROM  user as u, user_team as ut, team as te, team_tournament as teto, tournament as tou"
                                            + " WHERE tou.name = teto.tournament"
                                            + "   AND teto.team = te.name"
                                            + "   AND te.name = ut.team"
                                            + "   AND ut.user = u.username"
                                            + "   AND tou.name = '" + tournamentname + "'"
                                            + " ORDER BY u.username, u.wins");
            resultSet.first();
            
            
            while(!resultSet.isAfterLast()) {
                member.add(new User(resultSet.getString("u.username"), 
                                    resultSet.getString("u.email"), 
                                    resultSet.getString("u.password"), 
                                    new Statistics(resultSet.getInt("goals"), 
                                                   resultSet.getInt("goals_conceded"), 
                                                   resultSet.getInt("wins"),
                                                   resultSet.getInt("defeats"),
                                                   resultSet.getInt("tournament_wins"),
                                                   resultSet.getInt("tournament_participations")),
                                    resultSet.getDate("u.create_date")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return member;
    }
    
    public static List<User> getActiveUserFromTournament(String tournamentname) {
        List<User> member = new ArrayList<User>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT username, u.password, u.email, u.create_date, u.goals,  u.goals_conceded, u.wins, u.defeats, u.goals_conceded"
                                            + " FROM  user as u, user_team as ut, team as te, team_tournament as teto, tournament as tou"
                                            + " WHERE tou.name = teto.tournament"
                                            + "   AND teto.team = te.name"
                                            + "   AND te.name = ut.team"
                                            + "   AND ut.user = u.username"
                                            + "   AND tou.name = '" + tournamentname + "'"
                                            + "   AND (quit_dat is NULL OR quit_dat = '')"
                                            + " ORDER BY u.username, u.wins");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                member.add(new User(resultSet.getString("u.username"), 
                                    resultSet.getString("u.email"), 
                                    resultSet.getString("u.password"), 
                                    new Statistics(resultSet.getInt("goals"), 
                                                   resultSet.getInt("goals_conceded"), 
                                                   resultSet.getInt("wins"),
                                                   resultSet.getInt("defeats"),
                                                   resultSet.getInt("tournament_wins"),
                                                   resultSet.getInt("tournament_participations")),
                                    resultSet.getDate("u.create_date")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return member;
    }
    
    
    public static List<Tournament> getAllTournamentFromUser(String username) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            
            resultSet = statement.executeQuery("SELECT tou.name, tou.description, tou.create_date, tou.leader, tou.start_date, tou.end_date, tou.nr_of_matchdays, tou.venue, tou.term_of_application, tou.password"
                                            + " FROM  tournament tou, team_tournament teto, team te, user_team ut, user u"
                                            + " WHERE tou.name = teto.tournament"
                                            + "   AND teto.team = te.name" 
                                            + "   AND te.name = ut.team" 
                                            + "   AND ut.user = u.username" 
                                            + "   AND username = '" + username + "'"
                                            + " ORDER BY tou.name, tou.start_date, tou.end_date");
            resultSet.first();
            
            
            while(!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("tou.name"), resultSet.getString("tou.password"), resultSet.getString("description"), new User(resultSet.getString("tou.leader")), resultSet.getDate("tou.start_date"), resultSet.getDate("tou.end_date"), resultSet.getDate("tou.create_date"), resultSet.getInt("tou.nr_of_matchdays"), resultSet.getString("tou.venue"),resultSet.getDate("tou.term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        
        }
        return tournaments;
    }

    
}
