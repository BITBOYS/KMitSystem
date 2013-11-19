package com.kmitsystem.services.tournament;

import com.kmitsystem.services.tournament.input.AddTeamInput;
import com.kmitsystem.services.tournament.input.CreateTournamentInput;
import com.kmitsystem.services.tournament.input.GetEverythingInput;
import com.kmitsystem.services.tournament.input.SearchTournamentInput;
import com.kmitsystem.services.tournament.result.GetEverythingResult;
import com.kmitsystem.services.tournament.result.SearchTournamentResult;
import com.kmitsystem.services.tournament.validator.AddTeamValidator;
import com.kmitsystem.services.tournament.validator.CreateTournamentValidator;
import com.kmitsystem.services.tournament.validator.GetEverythingValidator;
import com.kmitsystem.tools.database.queries.DBTeamTournamentQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.database.queries.DBUserTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.sql.Date;

/**
 * @author Malte
 */
public class TournamentServiceProvider {
    
    CreateTournamentValidator createTournamentValidator = new CreateTournamentValidator();
    AddTeamValidator addTeamValidator = new AddTeamValidator();
    GetEverythingValidator getEverythingValidator = new GetEverythingValidator();
    
    public BaseResult createTeam(CreateTournamentInput input) {
        BaseResult result = new BaseResult();

        if(createTournamentValidator.validate(input)) {
            // prepare the input
            String name = input.getName();
            String password = input.getPassword();
            User leader = input.getLeader();
            String start_date = input.getStart_date();
            String end_date = input.getEnd_date();
            int nr_matchdays = input.getNr_matchdays();
            String venue = input.getVenue();
            String term_of_application = input.getTerm_of_application();
            
            // call the database
            //TODO:
//            DBTournamentQueries.createTournament(name, password, leader, end_date, start_date, nr_matchdays, venue, term_of_application);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
    public BaseResult addTeam(AddTeamInput input) {
        BaseResult result = new BaseResult();
        
        if(addTeamValidator.validate(input)) {
            // prepare the input
            String teamname = input.getTeamname();
            String tournamentname = input.getTournamentname();
            
            // call the database
            DBTeamTournamentQueries.addTeam(tournamentname, teamname);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
    
    public GetEverythingResult getEverything(GetEverythingInput input) {
        GetEverythingResult result = new GetEverythingResult();
        
        if(getEverythingValidator.validate(input)) {
            // prepare the input
            String tournamentname = input.getTournamentname();
            
            // call the database
            result.setTournament(DBTournamentQueries.getTournament(tournamentname));
//            TODO
//            result.setTournament(DBTeamTournamentQueries.getAllTournamentsFromTeam(teamname));
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
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

        // call the database
        // search tournament
        if(tournament_name != null && !tournament_name.equals(""))
            result.getTournaments().add(DBTournamentQueries.getTournament(tournament_name));
        
        // search team
        if(team_name != null && !team_name.equals("")) 
            result.addTournaments(DBTeamTournamentQueries.getAllTournamentsFromTeam(team_name));
        
        // search user
        if(user_name != null && !user_name.equals(""))
            result.addTournaments(DBUserTournamentQueries.getAllTournamentsFromUser(user_name));
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
    }
       
}

