package com.kmitsystem.tools.database;

import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Maik
 */
public class DatabaseHandler {
    
    private static String host = "jdbc:mysql://localhost:3306/kmitsystem";
    private static String username = "root";
    private static String password = "";
    private static Connection con = null;
    
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(con == null)
                con = DriverManager.getConnection(host, username, password);
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, DatabaseHandler.class.getName() + ":connect");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ErrorHandler.handle(Errors.DB_CONNECTION_ERROR, DatabaseHandler.class.getName() + ":connect");
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}
