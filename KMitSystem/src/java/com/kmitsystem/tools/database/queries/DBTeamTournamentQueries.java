package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.objects.Tournament;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maik
 */
public class DBTeamTournamentQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static List<Tournament> getAllTournamentsFromTeam(String teamname) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
            
//        try {
//            con = DatabaseHandler.connect();
//            statement = con.createStatement();
//            
//            statement.executeQuery("SELECT username, email, password, goals,"
//                                            + "goals_conceded, wins, defeats"
//                                 + " FROM  user, user_team"
//                                 + " WHERE team = " + teamname
//                                 + "   AND username = user" );
//            
//            while(!resultSet.isAfterLast()) {
//                tournaments.add(new Tournament(resultSet.getString("name"), 
//                                               resultSet.getString(teamname)null), teamname, null, null, null, nr_matchdays));
//                resultSet.next();
//            }
//        } catch (SQLException ex) {
//            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
//        }
        
        return tournaments;
    }
    
}
