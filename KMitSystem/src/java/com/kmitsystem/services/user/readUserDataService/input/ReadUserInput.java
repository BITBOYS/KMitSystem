package com.kmitsystem.services.user.readUserDataService.input;

/**
 *
 * @author Malte
 */
public class ReadUserInput {

    private String name;
    private String email;
    private String password;

    
    public ReadUserInput() {
        super();
    }
    
    public ReadUserInput(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

