/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.tools.database.queries;

import com.kmitsystem.services.team.TeamServiceProvider;
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
            resultSet = statement.executeQuery("select * from user where username='" + name + "'");
            resultSet.first();
            
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            Statistics statistics = new Statistics(resultSet.getInt("goals"), 
                                                   resultSet.getInt("goals_conceded"), 
                                                   resultSet.getInt("wins"), 
                                                   resultSet.getInt("defeats"), 
                                                   resultSet.getInt("tournament_wins"), 
                                                   resultSet.getInt("tournament_participations"));

            user = new User(username, email, password, statistics);
                
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState() + " " +ex.getMessage());
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
    
    public static User loginUser(String email, String password) {
        
        User user = null;
        
         try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * "
                                        + "FROM user "
                                        + "WHERE email='" + email + "'"
                                        + "AND password='" + password + "'");
            
            resultSet.first();
           
            String username = resultSet.getString("username");
            Statistics statistics = new Statistics(resultSet.getInt("goals"), 
                                                   resultSet.getInt("goals_conceded"), 
                                                   resultSet.getInt("wins"), 
                                                   resultSet.getInt("defeats"), 
                                                   resultSet.getInt("tournament_wins"), 
                                                   resultSet.getInt("tournament_participations"));
            user = new User(username, email, password, statistics);
                       
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.FALSE_LOGIN_INPUT, ex.getSQLState() + " " +ex.getMessage());
        }
        
         return user;
    }
    
    public static void changeEmail(String oldEmail, String newEmail) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            result = statement.executeUpdate("update user set email='"+ newEmail+"' where email = '"+ oldEmail+"'"); 
            
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBUserQueries.class.getName() + ":changeEmail");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }        
    }
   
     public static void changeName(String oldName, String newName) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            result = statement.executeUpdate("update user set username= '"+ newName+"' where username = '"+ oldName + "'");            
         
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBUserQueries.class.getName() + ":changeName");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }        
    }
    
     //BIn mir nicht sicher mit den SPaltennamen, kann die DB im MOment nicht öffnen
     
     public static void changePassword(String username, String newPassword) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            result = statement.executeUpdate("update user set password= '"+ newPassword+"' where username = '"+ username + "'");         
         
            if(result > 0)
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBUserQueries.class.getName() + ":changePassword");
            
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
