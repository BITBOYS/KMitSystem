/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.tools;

/**
 *
 * @author Oerlex
 */
public class PasswordPolicy {

    
    public PasswordPolicy() {
    }
    
    public Boolean CheckPassword(String password){
        
        return password.length()>7;
    }
}
