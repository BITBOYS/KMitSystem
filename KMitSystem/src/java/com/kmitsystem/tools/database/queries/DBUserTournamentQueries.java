package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
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
            resultSet = statement.executeQuery("SELECT username, u.email, u.password, u.wins, u.losses, u.goals, u.goals_conceded"
                                            + " FROM  user as u, user_team as ut, team as te, team_tournament as teto, tournament as to"
                                            + " WHERE to.name = teto.tournament"
                                            + "   AND teto.team = te.name" + "'"
                                            + "   AND te.name = ut.team" + "'"
                                            + "   AND ut.user = u.username" + "'"
                                            + "   AND to.name = '" + tournamentname + "'");
            resultSet.first();
            
            
            while(!resultSet.isAfterLast()) {
                member.add(new User(resultSet.getString("u.username"), resultSet.getString("u.password")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return member;
    }
    
    
    public static List<Tournament> getAllTournamentFromUser(String username) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            
            resultSet = statement.executeQuery("SELECT to.name, to.leader, to.start_date, to.end_date, to.nr_of_matchdays, to.venue, to.term_of_application, to.password"
                                            + " FROM  tournament as to, team_tournament as teto, team as te, user_team as ut, user as u"
                                            + " WHERE to.name = teto.tournament"
                                            + "   AND teto.team = te.name" + "'"
                                            + "   AND te.name = ut.team" + "'"
                                            + "   AND ut.user = u.username" + "'"
                                            + "   AND username = '" + username +"'");
            resultSet.first();
            
            
            while(!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("to.name"), resultSet.getString("to.password"), new User(resultSet.getString("to.leader")), resultSet.getDate("to.start_date"), resultSet.getDate("to.end_date"), resultSet.getInt("to.nr_of_matchdays"), resultSet.getString("to.venue"),resultSet.getDate("to.term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        
        }
        return tournaments;
    }

    
}
