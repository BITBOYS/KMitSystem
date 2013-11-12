package com.kmitsystem.services.user.readUserDataService.input;

import com.kmitsystem.tools.objects.User;

/**
 *
 * @author Malte
 */
public class ReadUserDataInput {

    private User user;

    
    public ReadUserDataInput() {
        super();
    }

    public ReadUserDataInput(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
}

