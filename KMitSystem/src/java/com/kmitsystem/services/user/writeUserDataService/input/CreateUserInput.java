package com.kmitsystem.services.user.writeUserDataService.input;

import com.kmitsystem.tools.objects.User;


/**
 * @author Alex
 */
public class CreateUserInput {
    
    private String name;    
    private String password;
    private String email;
    private int goals;
    private int goals_conceded;
    private int wins;
    private int defeats;

    public CreateUserInput(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public CreateUserInput(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 
    
    
    
    
    
}
