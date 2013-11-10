package com.kmitsystem.tools.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
