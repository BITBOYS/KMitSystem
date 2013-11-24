
package com.kmitsystem.services.user.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 *
 * @author Smadback
 */
public class ChangeUserSettingsResult extends BaseResult {
    
    User user;

    public ChangeUserSettingsResult() {
        super();
    }

    public ChangeUserSettingsResult(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
