package com.kmitsystem.services.team.result;

import com.kmitsystem.tools.objects.BaseResult;

/**
 * @author Maik
 */
public class EditTeamResult extends BaseResult {

    boolean querySuccessful;
    
    public EditTeamResult() {
        super();
    }     

    public EditTeamResult(boolean querySuccessful) {
        this.querySuccessful = querySuccessful;
    }    

    public boolean isQuerySuccessful() {
        return querySuccessful;
    }

    public void setQuerySuccessful(boolean querySuccessful) {
        this.querySuccessful = querySuccessful;
    }
        
}
