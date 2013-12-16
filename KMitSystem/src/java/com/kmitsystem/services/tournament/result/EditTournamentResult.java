package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;

/**
 *
 * @author Malte
 */
public class EditTournamentResult extends BaseResult{

    boolean querySuccessful;

    public EditTournamentResult() {
        super();
    }

    public EditTournamentResult(boolean querySuccessful) {
        this.querySuccessful = querySuccessful;
    }

    public boolean isQuerySuccessful() {
        return querySuccessful;
    }

    public void setQuerySuccessful(boolean querySuccessful) {
        this.querySuccessful = querySuccessful;
    }
}
