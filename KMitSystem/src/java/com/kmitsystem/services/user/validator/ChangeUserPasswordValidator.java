/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.ChangeUserPasswordInput;
import com.kmitsystem.tools.PasswordPolicy;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oerlex
 */
public class ChangeUserPasswordValidator {
     PasswordPolicy passwordPolicy = new PasswordPolicy();
    
    public boolean validate(ChangeUserPasswordInput input) {
        
        
        if(input.getNewPassword1().equals(input.getNewPassword2()) == false) {
            ErrorHandler.handle(Errors.PASSWORDS_NOT_EQUAL, DBUserQueries.class.getName() + ": isEmailExisting");
            return false;
        }
        
        if(passwordPolicy.CheckPassword(input.getNewPassword1()) == false){
            ErrorHandler.handle(Errors.PASSWORD_NOT_VALID);
            return false;
        }                 
        
        if(DBUserQueries.userPasswordOk("MAIL DER SESSION BEKOMMEN ?", input.getNewPassword2()) == false)
        {
            ErrorHandler.handle(Errors.FALSE_LOGIN_INPUT);
            return false;
        }        
        return true;
     
    }

}
