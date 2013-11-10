package com.kmitsystem.tools.database;

import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Maik
 */
public class DatabaseTeamQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static Team getTeam(String name) {
        Team team = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from team where name=\"" + name + "\"");
            
            if(resultSet.getFetchSize() == 1) {
                String teamname = resultSet.getString("name");
                String tag = resultSet.getString("tag");
                User leader = new User();
                String password = resultSet.getString("password");
                Statistics statistics = new Statistics();

                team = new Team(teamname, tag, password, leader, statistics);
            }
        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseTeamQueries.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return team;
    }
    
    public static void createTeam(Team team) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            String name = team.getName();
            String tag = team.getTag();
            String password = team.getPassword();
            String leader = team.getLeader().getUsername();
            
            if(password.equals("")) { 
                statement.execute("insert into team"
                            + "(name, tag, leader)"
                            + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + leader + "\")");  
            } else {
                statement.execute("insert into team"
                                + "(name, tag, password, leader)"
                                + "VALUES (\"" + name + "\",\"" + tag + "\",\"" + password + "\",\"" + leader + "\")"); 
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseTeamQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}