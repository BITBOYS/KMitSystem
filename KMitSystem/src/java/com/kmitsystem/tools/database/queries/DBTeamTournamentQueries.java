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
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Maik
 */
public class DBTeamTournamentQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static List<Tournament> getAllTournamentsFromTeam(String name) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
            
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, password , "
                                                     + "nr_of_matchdays, venue, term_of_application" +
                                              " FROM tournament, team_tournament" +
                                              " WHERE team =  '" + name + "'" +
                                              " AND tournament = name");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("name"),     resultSet.getString("password"), new User(resultSet.getString("leader")), 
                                               resultSet.getDate("start_date"), resultSet.getDate("end_date"),   resultSet.getInt("nr_of_matchdays"), 
                                               resultSet.getString("venue"),    resultSet.getDate("term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return tournaments;
    }
    
}
