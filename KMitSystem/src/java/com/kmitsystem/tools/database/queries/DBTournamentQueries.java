package com.kmitsystem.tools.database.queries;

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

/**
 * @author Malte
 */
public class DBTournamentQueries {

    private static Statement statement = null;
    private static Connection con = null;
    private static ResultSet resultSet = null;

    public static boolean isTournamentExisiting(String name) {
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
            resultSet = statement.executeQuery("select * from tournament where name=\"" + name + "\"");
            resultSet.first();

            String tournamentname = resultSet.getString("name");
            int nr_matchdays = resultSet.getInt("nr_matchdays");
            String password = resultSet.getString("password");
            String venue = resultSet.getString("venue");
            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");
            Date term_of_application = resultSet.getDate("term_of_application");
            User leader = new User();
//            Statistics statistics = new Statistics

            tournament = new Tournament(tournamentname, password, leader, start_date, end_date, nr_matchdays, venue, term_of_application);

        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.NO_ENTRYS_FOUND, ex.getSQLState() + " " + ex.getMessage());
        }
        return tournament;
    }

    public static void createTournament(String name, String password, User leader, Date end_date, Date start_date, int nr_matchdays, String venue, Date term_of_application) {
        try {
            con = DatabaseHandler.connect();
            statement = con.createStatement();

            statement.execute("insert into tournament"
                        + "(name, leader, start_date, end_date, password, nr_of_matchdays, venue, term_of_matchday)"
                        + "VALUES (\"" + name + "\",\"" + leader.getUsername() + "\",\"" + start_date + "\",\""  + start_date + "\",\"" + password + "\",\"" + nr_matchdays + "\",\"" + venue + "\",\"" + term_of_application + "\")");
            
        } catch (SQLException ex) {
            ErrorHandler.handle(Errors.DB_ERROR, ex.getSQLState() + " " + ex.getMessage());
        }
    }

}
