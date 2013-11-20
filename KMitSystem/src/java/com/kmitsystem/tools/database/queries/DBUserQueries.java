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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Oerlex, Malte
 */
public class DBUserQueries {
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static boolean isEMailExisting(String email) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count "
                                             + "from user "
                                             + "where email='" + email + "';");
            resultSet.first();
            
            if(resultSet.getInt("count") > 0 )
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
        public static boolean isUsernameExisting(String username) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count "
                                             + "from user "
                                             + "where username='" + username + "';");
            resultSet.first();
            
            if(resultSet.getInt("count") > 0 )
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
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
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        return user;
    }
    
    public static void createUser(String name, String email, String password) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
             statement.execute("insert into user"
                        + "(username, password, email)"
                        + "VALUES (\"" + name + "\",\"" + password + "\",\"" + email + "\")");
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    public static Boolean userPasswordOk(String email, String password) {
        
        Boolean result = false;
        
         try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count "
                                        + "from user "
                                        + "where email='" + email + "'"
                                        + "and password='" + password + "'");
            
            resultSet.first();
           
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
         return result;
    }
    
    public static void changeEmail(String oldEmail, String newEmail) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            statement.execute("update user set email="+ newEmail+" where email ="+ oldEmail);            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }        
    }
   
     public static void changeName(String oldName, String newName) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            statement.execute("update user set name="+ newName+" where name ="+ oldName);            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }        
    }
    
     //BIn mir nicht sicher mit den SPaltennamen, kann die DB im MOment nicht öffnen
     
     public static void changePassword(String oldPassword, String newPassword) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            statement.execute("update user set password="+ newPassword+" where password ="+ oldPassword);            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }        
    }
     
     public static List<User> getAllUser() {
        List<User> user = new ArrayList<User>();
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT username FROM user");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                user.add(new User(resultSet.getString("username")));
                resultSet.next();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUserQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
     }
    
}
