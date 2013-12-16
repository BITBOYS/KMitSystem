package com.kmitsystem.tools.database.queries;

import com.kmitsystem.tools.DateKonverter;
import com.kmitsystem.tools.database.DatabaseHandler;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Malte
 */
public class DBTournamentQueries {

    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;

    public static boolean isTournamentExisting(String name) {
        boolean result = false;

        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select COUNT(*) as count from tournament where name=\"" + name + "\"");
            resultSet.first();

            if (resultSet.getInt("count") > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " + ex.getMessage());
        }

        return result;
    }

    public static Tournament getTournament(String name) {
        Tournament tournament = null;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from tournament where name= '" + name + "' ORDER BY name, start_date, end_date");
            resultSet.first();

            String tournamentname = resultSet.getString("name");
            int nr_matchdays = resultSet.getInt("nr_of_matchdays");
            String password = resultSet.getString("password");
            String description = resultSet.getString("description");
            String venue = resultSet.getString("venue");
            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");
            Date create_date = resultSet.getDate("create_date");
            Date term_of_application = resultSet.getDate("term_of_application");
            User leader = new User(resultSet.getString("leader"));
            
            tournament = new Tournament(tournamentname, password, description, leader, start_date, end_date, create_date, nr_matchdays, venue, term_of_application);

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournament;
    }
    
    //TODO
    public static List<Tournament> getTournamentsByMonth(String create_month) {
        List<Tournament> tournaments = new ArrayList<Tournament>();
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            
            resultSet = statement.executeQuery("SELECT name, create_date"
                                            + " FROM  tournament "
                                            + " WHERE MONTHNAME(create_date) = '" + create_month + "'" 
                                            + " ORDER BY create_date");
            resultSet.first();
            
            
            while(!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("name")));
                        resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournaments;
    }
    
    
    public static void createTournament(String name, String password, String description, User leader, Date end_date, Date start_date, int nr_matchdays, String venue, Date term_of_application) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            statement.execute("insert into tournament"
                        + "(name, leader, start_date, end_date, password, description, nr_of_matchdays, venue, term_of_application)"
                        + "VALUES ('" + name + "','" + leader.getUsername() + "','" + start_date + "','" + end_date + "','" + password + "','" + description + "','" + nr_matchdays + "','" + venue + "','" + term_of_application + "')");
            
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " + ex.getMessage());
        }
    }
    
    public static boolean editTournamentName(String tournamentname, String new_name) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                     + "SET name = '" + new_name + "' "
                                     + "WHERE name = '" + tournamentname + "'" );
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editName");
                return true;
            }
            
        } catch (SQLException ex) {
                 ErrorHandler.handle(Errors.DB_ERROR, "editName: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentPassword(String tournamentname, String new_password) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET password = '" + new_password + "' "
                                           + "WHERE name = '" + tournamentname + "'" );
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editPassword");
                return true;
            }
            
        } catch (SQLException ex) {
             ErrorHandler.handle(Errors.DB_ERROR, "editPassword: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentLeader(String tournamentname, String new_leader) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET leader = '" + new_leader + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editLeader");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editLeader: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentVenue(String tournamentname, String new_venue) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET venue = '" + new_venue + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editVenue");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editVenue: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentDescription(String tournamentname, String description) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET description = '" + description + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editDescription");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editVenue: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentMatchdays(String tournamentname, int new_nr_matchdays) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET nr_of_matchdays = '" + new_nr_matchdays + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editMatchdays");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editMatchdays: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentTerm(String tournamentname, Date new_term_of_application) {
        int result;
        try {            
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET term_of_application = '" + DateKonverter.getWebDateString(new_term_of_application) + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editTerm");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTerm: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
    
    public static boolean editTournamentStart(String tournamentname, Date new_start_date) {
        int result;
        try {            
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET start_date = '" + DateKonverter.getWebDateString(new_start_date) + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editStart");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editStart: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentEnd(String tournamentname, Date new_end_date) {
        int result;
        try {            
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            
            result = statement.executeUpdate("UPDATE tournament"
                                           + "SET start_date = '" + DateKonverter.getWebDateString(new_end_date) + "' "
                                           + "WHERE name = '" + tournamentname + "'");
            
            if(result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editEnd");
                return true;
            }
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editEnd: " + ex.getSQLState() + " " +ex.getMessage());
        }
        return false;
    }
}
