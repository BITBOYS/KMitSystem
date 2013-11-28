package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Statistics;
import com.kmitsystem.tools.objects.Table;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Maik, Malte
 */
public class DBTeamTournamentQueries {
    
    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    
    public static void addTeam(String tournamentname, String teamname) {
        try {        
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date enter_date = new Date();
            
            statement.execute("INSERT INTO team_tournament"
                    + "(team, tournament, enter_date)"
                    + "VALUES ('" + teamname + "','" + tournamentname + "','" + formatter.format(enter_date) + "')");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
    }
    
    // TODO: löschen jeglicher statistiken, die das team während des turniers aufgestellt hat
    public static boolean removeTeam(String tournamentname, String teamname) {
        int result;
        try {        
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("DELETE FROM team_tournament "
                                            + "WHERE tournament = '" + tournamentname + "'"
                                            + "  AND team = '" + teamname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.LEAVE_TOURNAMENT_SUCCESSFUL, DBTeamTournamentQueries.class.getName() + ":removeTeam");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, DBTeamTournamentQueries.class.getName() + ":removeTeam; " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static List<Tournament> getAllTournamentsFromTeam(String name) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
            
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT name, description, leader, start_date, end_date, create_date, password , "
                                                     + "nr_of_matchdays, venue, term_of_application" +
                                              " FROM tournament, team_tournament" +
                                              " WHERE team =  '" + name + "'" +
                                              " AND tournament = name" +
                                              " ORDER BY name");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("name"),     resultSet.getString("password"), resultSet.getString("description"), new User(resultSet.getString("leader")), 
                                               resultSet.getDate("start_date"), resultSet.getDate("end_date"),   resultSet.getDate("create_date"),               resultSet.getInt("nr_of_matchdays"), 
                                               resultSet.getString("venue"),    resultSet.getDate("term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState() + " " +ex.getMessage());
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return tournaments;
    }
    
    /**
     * Checks if the team is a member of a specific tournament
     * returns: true if it is a team, false if it's not
     * @param teamname
     * @param tournamentname
     * @return boolean
     */
    public static boolean checkTournamentMembership(String teamname, String tournamentname) {
        boolean result = false;
        
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT COUNT(*) as count "
                                    + " FROM team_tournament "
                                    + " WHERE team = '" + teamname + "'"
                                    + "   AND tournament = '" + tournamentname + "'");
            
            resultSet.first();
            
            if(resultSet.getInt("count") > 0)
                result = true;
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return result;
    }
    
    
    public static List<Team> getAllTeamsFromTournament(String name) {
        List<Team> teams = new ArrayList<Team>();
            
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT name, tag, password, leader, team.wins, team.defeats, "
                                                    + "team.goals, team.goals_conceded, team.tournament_wins, team.tournament_participations, team.create_date" +
                                              " FROM team, team_tournament" +
                                              " WHERE tournament =  '" + name + "'" +
                                              " AND team = name" +
                                              " ORDER BY name, team.wins");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                teams.add(new Team(resultSet.getString("name"), 
                                   resultSet.getString("tag"),
                                   resultSet.getString("password"), 
                                   new User(resultSet.getString("leader")), 
                                   new Statistics(resultSet.getInt("team.goals"), resultSet.getInt("team.goals_conceded"), 
                                                  resultSet.getInt("team.wins"), resultSet.getInt("team.defeats"), resultSet.getInt("team.tournament_wins"), 
                                                  resultSet.getInt("team.tournament_participations")), 
                                   resultSet.getDate("team.create_date")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return teams;
    }
    
    public static List<Table> getTableFromTournament(String name) {
        List<Table> table = new ArrayList<Table>();
            
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            resultSet = statement.executeQuery("SELECT * " +
                                               "  FROM team_tournament " +
                                               " WHERE tournament = '" + name + "'" +
                                               " ORDER BY (wins/(wins+defeats)) DESC");
            resultSet.first();
            
            while(!resultSet.isAfterLast()) {
                table.add(new Table(resultSet.getInt("wins"),  resultSet.getInt("defeats"), 
                                  resultSet.getInt("goals"), resultSet.getInt("goals_conceded")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " +ex.getMessage());
        }
        
        return table;
    }
    
    /*
     
     
      
      
     */
    
}
