/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maik
 */
public class DBUserTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static void addPlayer(User user, Team team) {
        try {        
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            String username = user.getUsername();
            String teamname = team.getName();
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date enter_date = new Date();
            
            statement.execute("INSERT INTO user_team"
                    + "(user, team, enter_date)"
                    + "VALUES ('" + username + "','" + teamname + "','" + formatter.format(enter_date) + "')");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBTeamQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Checks if the user is a member of a specific team
     * returns: true if he is a member, false if he's not
     */
    public static boolean checkTeamMembership(User user, Team team) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            String username = user.getUsername();
            String teamname = team.getName();
            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count "
                                    + " FROM user_team "
                                    + " WHERE user = '" + username + "'"
                                    + "   AND team = '" + teamname + "'");
            
            resultSet.first();
            
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
}
