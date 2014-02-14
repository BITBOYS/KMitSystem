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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Malte
 */
public class DBTournamentQueries {

    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;
    private static final DateFormat FORMATTER_S = new SimpleDateFormat("HH:mm");
    private static final DateFormat FORMATTER_E = new SimpleDateFormat("HH:mm");

    public static boolean isTournamentExisting(String name) {
        boolean result = false;

        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT(*) AS count "
                    + "FROM tournament "
                    + "WHERE name= '" + name + "'");
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
            resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time"
                    + "FROM tournament "
                    + "WHERE name= '" + name + "' "
                    + "ORDER BY name, start_date, end_date");
            resultSet.first();

            String tournamentname = resultSet.getString("name");
            int nr_matchdays = resultSet.getInt("nr_of_matchdays");
            String password = resultSet.getString("password");
            String description = resultSet.getString("description");
            String venue = resultSet.getString("venue");
            Date start_date = resultSet.getDate("start_date");
            java.sql.Time start_time = resultSet.getTime("start_time");
            Date end_date = resultSet.getDate("end_date");
            java.sql.Time end_time = resultSet.getTime("end_time");
            Date create_date = resultSet.getDate("create_date");
            Date term_of_application = resultSet.getDate("term_of_application");
            User leader = new User(resultSet.getString("leader"));

            tournament = new Tournament(tournamentname, password, description, leader, start_date, start_time, end_date, end_time, create_date, nr_matchdays, venue, term_of_application);

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournament;
    }

    public static ArrayList<Tournament> getTournamentsByMonth(String create_month) {
        ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

        String year = create_month.substring(0, 4);
        int yearNum = Integer.parseInt(year);
        String month = create_month.substring(5);
        int monthNum = Integer.parseInt(month);

        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time"
                    + " FROM  tournament "
                    + " WHERE YEAR(create_date) = '" + yearNum + "'"
                    + " AND MONTH(create_date) = '" + monthNum + "'"
                    + " ORDER BY create_date");
            resultSet.first();

            while (!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("description"),
                        new User(resultSet.getString("leader")),
                        resultSet.getDate("start_date"),
                        resultSet.getTime("start_time"),
                        resultSet.getDate("end_date"),
                        resultSet.getTime("end_time"),
                        resultSet.getDate("create_date"),
                        resultSet.getInt("nr_of_matchdays"),
                        resultSet.getString("venue"),
                        resultSet.getDate("term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournaments;
    }

    public static ArrayList<Tournament> getTournamentsRunningFinished(char status) {
        ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            if (status == 'r') {
                resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time"
                        + " FROM  tournament "
                        + " WHERE CURDATE() < end_date"
                        + " ORDER BY end_date");
                resultSet.first();

            } else if (status == 'f') {
                resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time"
                        + " FROM  tournament "
                        + " WHERE CURDATE() > end_date"
                        + " ORDER BY end_date");
                resultSet.first();

            } else if (status == 'o') {
                resultSet = statement.executeQuery("SELECT name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time"
                        + " FROM  tournament "
                        + " WHERE CURDATE() < start_date"
                        + " ORDER BY end_date");
                resultSet.first();
            }
            while (!resultSet.isAfterLast()) {
                tournaments.add(new Tournament(resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("description"),
                        new User(resultSet.getString("leader")),
                        resultSet.getDate("start_date"),
                        resultSet.getTime("start_time"),
                        resultSet.getDate("end_date"),
                        resultSet.getTime("end_time"),
                        resultSet.getDate("create_date"),
                        resultSet.getInt("nr_of_matchdays"),
                        resultSet.getString("venue"),
                        resultSet.getDate("term_of_application")));
                resultSet.next();
            }
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournaments;
    }

    public static void createTournament(String name, String password, String description, User leader, String start_date, String start_time, String end_date, String end_time, String nr_matchdays, String venue, String term_of_application) throws ParseException {
        try {
            //Cast String to sql-Time
            Time startTime = new Time(FORMATTER_S.parse(start_time).getTime());
            Time endTime = new Time(FORMATTER_E.parse(end_time).getTime());

            con = DatabaseHandler.connect();
            statement = con.createStatement();

            statement.execute("insert into tournament"
                    + "(name, leader, start_date, end_date, create_date, password, description, nr_of_matchdays, venue, term_of_application, start_time, end_time)"
                    + " VALUES ('" + name + "','" + leader.getUsername() + "','" + start_date + "','" + end_date + "',CURRENT_TIMESTAMP,'" + password + "','" + description + "','" + nr_matchdays + "','" + venue + "','" + term_of_application + "','" + startTime + "','" + endTime + "')");

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " + ex.getMessage());
        }
    }

    public static boolean editTournamentName(String tournamentname, String new_name) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET name = '" + new_name + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editName");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editName: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentPassword(String tournamentname, String new_password) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET password = '" + new_password + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editPassword");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editPassword: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentLeader(String tournamentname, String new_leader) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET leader = '" + new_leader + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editLeader");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editLeader: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentVenue(String tournamentname, String new_venue) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET venue = '" + new_venue + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editVenue");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editVenue: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentDescription(String tournamentname, String description) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET description = '" + description + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editDescription");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editVenue: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentMatchdays(String tournamentname, int new_nr_matchdays) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET nr_of_matchdays = '" + new_nr_matchdays + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editMatchdays");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editMatchdays: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentTerm(String tournamentname, Date new_term_of_application) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET term_of_application = '" + DateKonverter.getWebDateString(new_term_of_application) + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editTerm");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editTerm: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentStart(String tournamentname, Date new_start_date) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET start_date = '" + DateKonverter.getWebDateString(new_start_date) + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editStart");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editStart: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean editTournamentEnd(String tournamentname, Date new_end_date) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("UPDATE tournament "
                    + "SET start_date = '" + DateKonverter.getWebDateString(new_end_date) + "' "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.EDIT_SUCCESS, DBTournamentQueries.class.getName() + ":editEnd");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editEnd: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }

    public static boolean deleteTournament(String tournamentname) {
        int result;
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            result = statement.executeUpdate("DELETE FROM tournament "
                    + "WHERE name = '" + tournamentname + "'");

            if (result > 0) {
                ErrorHandler.handle(Errors.TOURNAMENT_DELETE_SUCCESSFUL, DBTournamentQueries.class.getName() + ":deleteTournament");
                return true;
            }

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, "editEnd: " + ex.getSQLState() + " " + ex.getMessage());
        }
        return false;
    }
}
