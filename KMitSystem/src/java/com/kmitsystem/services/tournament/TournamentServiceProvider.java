package com.kmitsystem.services.tournament;

import com.kmitsystem.services.tournament.input.AddTeamInput;
import com.kmitsystem.services.tournament.input.CreateTournamentInput;
import com.kmitsystem.services.tournament.input.DeleteTournamentInput;
import com.kmitsystem.services.tournament.input.EditTournamentInput;
import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.services.tournament.input.SearchTournamentInput;
import com.kmitsystem.services.tournament.result.EditTournamentResult;
import com.kmitsystem.services.tournament.result.GetEverythingResult;
import com.kmitsystem.services.tournament.result.SearchTournamentResult;
import com.kmitsystem.services.tournament.validator.AddTeamValidator;
import com.kmitsystem.services.tournament.validator.CreateTournamentValidator;
import com.kmitsystem.services.tournament.validator.DeleteTournamentValidator;
import com.kmitsystem.services.tournament.validator.EditTournamentValidator;
import com.kmitsystem.services.tournament.validator.GetEverythingValidator;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Tournament;
import com.kmitsystem.tools.objects.User;
import java.sql.Date;

/**
 * @author Malte
 */
public class TournamentServiceProvider {

    CreateTournamentValidator createTournamentValidator = new CreateTournamentValidator();
    AddTeamValidator addTeamValidator = new AddTeamValidator();
    GetEverythingValidator getEverythingValidator = new GetEverythingValidator();
    EditTournamentValidator editTournamentValidator = new EditTournamentValidator();
    DeleteTournamentValidator deleteTournamentValidator = new DeleteTournamentValidator();

    public BaseResult createTournament(CreateTournamentInput input) {
        BaseResult result = new BaseResult();

        if (createTournamentValidator.validate(input)) {

            // prepare the input
            String name = input.getName();
            String password = input.getPassword();
            User leader = input.getLeader();
            String description = input.getDescription();
            Date start_date = input.getStart_date();
            Date end_date = input.getEnd_date();
            int nr_matchdays = input.getNr_matchdays();
            String venue = input.getVenue();
            Date term_of_application = input.getTerm_of_application();

            // call the database
            //TODO:Date
            DBTournamentQueries.createTournament(name, password, description, leader, start_date, end_date, nr_matchdays, venue, term_of_application);
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }
    
    public EditTournamentResult deleteTournament(DeleteTournamentInput input) {
        EditTournamentResult result = new EditTournamentResult();

        if (deleteTournamentValidator.validate(input)) {

            // prepare the input
            String tournamentname = input.getTournamentToDelete();

            // call the database
            DBTournamentQueries.deleteTournament(tournamentname);
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public BaseResult addTeam(AddTeamInput input) {
        BaseResult result = new BaseResult();

        if (addTeamValidator.validate(input)) {
            // prepare the input
            String teamname = input.getTeamname();
            String tournamentname = input.getTournamentname();

            // call the database
            DBTeamTournamentQueries.addTeam(tournamentname, teamname);
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public GetEverythingResult getEverything(GetEverythingInput input) {
        GetEverythingResult result = new GetEverythingResult();

        if (getEverythingValidator.validate(input)) {
            // prepare the input
            String tournamentname = input.getTournamentname();
            
            // call the database
            Tournament tournament = DBTournamentQueries.getTournament(tournamentname);
            
            tournament.setTable(DBTeamTournamentQueries.getTableFromTournament(tournamentname));
            
            result.setTournament(tournament);
            result.setTeams(DBTeamTournamentQueries.getAllTeamsFromTournament(tournamentname));
            result.setMember(DBUserTournamentQueries.getAllUserFromTournament(tournamentname));
        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    // no validation needed, because there are no false inputs
    public SearchTournamentResult searchTournament(SearchTournamentInput input) {

        SearchTournamentResult result = new SearchTournamentResult();

        // prepare the input
        String team_name = input.getTeam();
        String tournament_name = input.getTournament();
        String user_name = input.getUser();
        String month = input.getCreateMonth();
        Boolean running = input.getTournamentIsRunning();
        Boolean finished = input.getTournamentIsFinished();

        // call the database
        // search tournament
        if (tournament_name != null && !tournament_name.equals("")) {
            result.addTournament(DBTournamentQueries.getTournament(tournament_name));
        }

        // search team
        if (team_name != null && !team_name.equals("")) {
            result.addTournaments(DBTeamTournamentQueries.getAllTournamentsFromTeam(team_name));
        }

        // search user
        if (user_name != null && !user_name.equals("")) {
            result.addTournaments(DBUserTournamentQueries.getAllTournamentFromUser(user_name));
        }
        
        // search month
        if (month != null && !month.equals("")) {
            result.addTournaments(DBTournamentQueries.getTournamentsByMonth(month));
        }
        
        // search running
//        if (running) {
//            //TODO
//        }
//        
//        // search month
//        if (finished) {
//            //TODO
//        }

        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

    public EditTournamentResult editTournament(EditTournamentInput input) {
        EditTournamentResult result = new EditTournamentResult();

        if (editTournamentValidator.validate(input)) {
            // prepare the input
            String tournamentname = input.getTournamentname();
            String new_name = input.getNew_name();
            String new_password = input.getNew_password();
            String new_leader = input.getNew_leader();
            String new_venue = input.getNew_venue();
            String kickedTeam = input.getKick_team();
            String inviteTeam = input.getInvite_team();
            int new_nr_matchdays = input.getNew_nr_matchdays();
            Date new_term_of_application = input.getNew_term_of_application();
            Date new_start_date = input.getNew_start_date();
            Date new_end_date = input.getNew_end_date();
            
            boolean query = false;

            // call the database
            if (new_name != null) {
                query = DBTournamentQueries.editTournamentName(tournamentname, new_name);
            }
            if (new_password != null) {
                query = DBTournamentQueries.editTournamentPassword(tournamentname, new_password);
            }
            if (new_leader != null) {
                query = DBTournamentQueries.editTournamentLeader(tournamentname, new_leader);
            }
            if (new_venue != null) {
                query = DBTournamentQueries.editTournamentVenue(tournamentname, new_venue);
            }
            if (new_nr_matchdays <= 0) {
                DBTournamentQueries.editTournamentMatchdays(tournamentname, new_nr_matchdays);
            }
            if (new_term_of_application != null) {
                query = DBTournamentQueries.editTournamentTerm(tournamentname, new_term_of_application);
            }
            if (new_start_date != null) {
                query = DBTournamentQueries.editTournamentStart(tournamentname, new_start_date);
            }
            if (new_end_date != null) {
                query = DBTournamentQueries.editTournamentEnd(tournamentname, new_end_date);
            }
            if (input.getKick_team()!= null) {
                query = DBTeamTournamentQueries.removeTeam(tournamentname, kickedTeam);
            }
            
            result.setQuerySuccessful(query);
        }
        // write the errors into the result object and empty the ErrorHandler
        if (ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());
            ErrorHandler.clear();
        }

        return result;
    }

}
