package com.kmitsystem.services.user.writeUserDataService.input;


/**
 * @author Alex, Malte
 */
public class CreateUserInput {
    
    private User user;

    public CreateUserInput(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
