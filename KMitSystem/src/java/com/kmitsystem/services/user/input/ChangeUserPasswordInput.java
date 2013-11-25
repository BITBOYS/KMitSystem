/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.input;

/**
 *
 * @author Oerlex
 */
public class ChangeUserPasswordInput {
    
    String username;
    String oldPassword;
    String newPassword1;
    String newPassword2;

    public ChangeUserPasswordInput(String username, String oldPassword, String newPassword1, String newPassword2) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword1 = newPassword1;
        this.newPassword2 = newPassword2;
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
    
    
    
    
}
