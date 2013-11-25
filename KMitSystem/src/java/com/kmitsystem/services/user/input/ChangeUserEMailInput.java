/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.input;

/**
 *
 * @author Oerlex
 */
public class ChangeUserEMailInput {
    
    String oldEmail;
    String newEmail1;
    String newEmail2;

    public ChangeUserEMailInput(String oldEmail, String newEmail1,String newEmail2) {
        this.oldEmail = oldEmail;
        this.newEmail1 = newEmail1;
        this.newEmail2 = newEmail2;
    }   
    
    public String getNewEmail1() {
        return newEmail1;
    }

    public void setNewEmail1(String newEmail1) {
        this.newEmail1 = newEmail1;
    }

    public String getNewEmail2() {
        return newEmail2;
    }

    public void setNewEmail2(String newEmail2) {
        this.newEmail2 = newEmail2;
    }
    
    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }  
}
