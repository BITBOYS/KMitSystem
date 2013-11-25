
package com.kmitsystem.services.user.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 *
 * @author Smadback
 */
public class ChangeUserSettingsResult extends BaseResult {
    
    User user;
    boolean querySuccess;

    public ChangeUserSettingsResult() {
        super();
    }

    public ChangeUserSettingsResult(User user, boolean querySuccess) {
        super();
        this.user = user;
        this.querySuccess = querySuccess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isQuerySuccess() {
        return querySuccess;
    }

    public void setQuerySuccess(boolean querySuccess) {
        this.querySuccess = querySuccess;
    }
    
}
