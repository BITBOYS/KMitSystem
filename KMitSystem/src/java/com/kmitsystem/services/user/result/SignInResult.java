package com.kmitsystem.services.user.result;

import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 * @author Maik
 */
public class SignInResult extends BaseResult {
    
    private User user;

    public SignInResult() {
        super();
    }

    public SignInResult(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
