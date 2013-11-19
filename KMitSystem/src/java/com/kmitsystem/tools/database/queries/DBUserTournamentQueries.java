/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.objects.Tournament;
import java.sql.Connection;
import java.sql.ResultSet;
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
    
    public static List<Tournament> getAllTournamentsFromUser(String username) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
//        
//        try {
//            con = DatabaseHandler.connect();
//            statement = con.createStatement();
//            
//            resultSet = statement.executeQuery("SELECT name, tag, team.password, leader, team.wins, team.defeats, "
//                                                    + "team.goals, team.goals_conceded, team.tournament_wins, team.tournament_participations"
//                                            + " FROM  team, user_team"
//                                            + " WHERE user = '" + username + "'"
//                                            + "   AND team = name" );
//            resultSet.first();
//            
//            while(!resultSet.isAfterLast()) {
//                tournaments.add(new Tournament(resultSet.getString("name"), resultSet.getString("password"),);
//                resultSet.next();
//            }
//        } catch (SQLException ex) {
//            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        
        
        return tournaments;
    }

    
}
