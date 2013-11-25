/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.ChangeUserPasswordInput;
import com.kmitsystem.tools.PasswordPolicy;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Oerlex
 */
public class ChangeUserPasswordValidator {
     PasswordPolicy passwordPolicy = new PasswordPolicy();
    
    public boolean validate(ChangeUserPasswordInput input) {
        
        if(passwordPolicy.CheckPassword(input.getNewPassword1()) == false){
            ErrorHandler.handle(Errors.PASSWORD_NOT_VALID);
            return false;
        }
        
        return true;
     
    }

}
