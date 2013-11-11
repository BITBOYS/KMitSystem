/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.tools.database;

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
 *
 * @author Oerlex
 */
public class DatabaseUserQueries {
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static int countUser(String name) {
        int teams = 0;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from user where name=\"" + name + "\"");
            resultSet.first();
            teams = resultSet.getInt("count");
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teams;
    }
    
    public static User getUser(String name) {
        User user = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from user where name=\"" + name + "\"");
            
            if(resultSet.getFetchSize() != 0) {
                String username = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Statistics statistics = new Statistics();

                user = new User(username, password, email, statistics);
                System.out.println(user.toString());
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return user;
    }
    
    public static void createUser(User user) {
        
        try {
            System.out.println("CREATE USER");
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            String name = user.getUsername();
            String email = user.getEmail();
            String password = user.getPassword();
            
             statement.execute("insert into user"
                        + "(username, password, email)"
                        + "VALUES (\"" + name + "\",\"" + password + "\",\"" + email + "\")");
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
}
