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
            resultSet = statement.executeQuery("SELECT name"
                                            + " FROM  user, tournament"
                                            + " WHERE tournament = '" + tournamentname + "'"
                                            + "   AND user = name" );
            resultSet.first();
            
            //TODO
//            while(!resultSet.isAfterLast()) {
//                tournaments.add(new Tournament(resultSet.getString("name"), resultSet.getString("password"),);
//                resultSet.next();
//            }
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
            
            //TODO
            resultSet = statement.executeQuery("SELECT name"
                                            + " FROM  tournament, user"
                                            + " WHERE user = '" + username + "'"
                                            + "   AND tounament = name" );
            resultSet.first();
            
            //TODO
//            while(!resultSet.isAfterLast()) {
//                tournaments.add(new Tournament(resultSet.getString("name"), resultSet.getString("password"),);
//                resultSet.next();
//            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        
        }
        return tournaments;
    }

    
}
