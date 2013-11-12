/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Oerlex, Malte
 */
public class DBUserQueries {
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    private static ResultSet resultSetName = null;
    private static ResultSet resultSetEmail = null;
    
    public static boolean isUserExisting(User user) {
        boolean result = false;
        String name = user.getUsername();
        String email = user.getEmail();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSetName = statement.executeQuery("select COUNT(*) as count "
                                             + "from user "
                                             + "where username='" + name + "'");
            resultSetName.first();
            
            resultSetEmail = statement.executeQuery("select COUNT(*) as count "
                                             + "from user "
                                             + "where email='" + email + "'");
            
            resultSetEmail.first();
            
            if(resultSetName.getInt("count") > 0 || resultSetEmail.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
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
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return user;
    }
    
    public static void createUser(User user) {
        try {
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

    public static boolean isUserExisiting(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Boolean userPasswordOk(User user) {
        
        Boolean result = null;
        String email = user.getEmail();
        String password = user.getPassword();
        
         try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from user where email=\"" + email + "\" and password=\"" + password + "\")");
            
            resultSet.first();
           
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
         return result;
    }
   
}
