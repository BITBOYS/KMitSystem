
package com.kmitsystem.services.user.input;

/**
 *
 * @author Smadback
 */
public class GetEverythingInput {
    
    String username;

    public GetEverythingInput(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
