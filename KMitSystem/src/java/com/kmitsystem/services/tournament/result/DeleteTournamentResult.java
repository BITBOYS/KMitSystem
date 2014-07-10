
package com.kmitsystem.services.tournament.result;

import com.kmitsystem.tools.objects.BaseResult;

/**
 *
 * @author Malte
 */
public class DeleteTournamentResult extends BaseResult{
    
    boolean querySuccessful;

    public DeleteTournamentResult() {
        super();
    }

    public boolean isQuerySuccessful() {
        return querySuccessful;
    }

    public void setQuerySuccessful(boolean querySuccessful) {
        this.querySuccessful = querySuccessful;
    }

    @Override
    public String toString() {
        return "DeleteTournamentResult{" + "querySuccessful=" + querySuccessful + '}';
    }
    
}
