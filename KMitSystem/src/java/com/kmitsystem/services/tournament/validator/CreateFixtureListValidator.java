package com.kmitsystem.services.tournament.validator;

import com.kmitsystem.services.tournament.input.CreateFixtureListInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBTournamentQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Malte
 */
public class CreateFixtureListValidator {

    public boolean validate(CreateFixtureListInput input) {

        // check if the team with that name exists
        for (int i = 0; i < input.getSpielplan().getRounds().size(); i++) {
            if (!DBTeamQueries.isTeamExisiting(input.getSpielplan().getRounds().get(i).getMatches().get(i).getTeam1().getName())) {
                ErrorHandler.handle(Errors.TEAM_DOES_NOT_EXIST, DBTournamentQueries.class.getName() + ":isInvalidTeam");
                return false;
            }
        }
        return true;
    }
}
