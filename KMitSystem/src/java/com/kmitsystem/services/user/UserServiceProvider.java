package com.kmitsystem.services.user;

import com.kmitsystem.services.user.input.ChangeUserEMailInput;
import com.kmitsystem.services.user.input.CreateUserInput;
import com.kmitsystem.services.user.input.SignInInput;
import com.kmitsystem.services.user.validator.CreateUserValidator;
import com.kmitsystem.services.user.validator.SignInValidator;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import com.kmitsystem.services.user.validator.ChangeUserEMailValidator;
import com.kmitsystem.services.user.validator.ChangeUserPasswordValidator;
import com.kmitsystem.services.user.validator.ChangeUserNameValidator;
import com.kmitsystem.services.user.input.ChangeUserNameInput;
import com.kmitsystem.services.user.input.ChangeUserPasswordInput;
import com.kmitsystem.services.user.result.ChangeUserSettingsResult;
import com.kmitsystem.services.user.result.SignInResult;

/**
 * @author Alex, Malte
 */
public class UserServiceProvider {
    
    CreateUserValidator createUserValidator = new CreateUserValidator();
    SignInValidator signInValidator = new SignInValidator();
    ChangeUserEMailValidator changeUserEMailValidator = new ChangeUserEMailValidator();
    ChangeUserNameValidator changeUserNameValidator = new ChangeUserNameValidator();
    ChangeUserPasswordValidator changeUserPasswordValidator = new ChangeUserPasswordValidator();
    
    public BaseResult createUser(CreateUserInput input) {
        BaseResult result = new BaseResult();

        if(createUserValidator.validate(input)) {
            // prepare the input
            String name = input.getName();
            String email = input.getEmail();
            String password = input.getPassword();
            
            // call the database
            DBUserQueries.createUser(name, email, password);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
    public SignInResult signInUser(SignInInput input) {
        SignInResult result = new SignInResult();

        // prepare the input
        String email = input.getEmail();
        String password = input.getPassword();

        // call the database
        result.setUser(DBUserQueries.loginUser(email, password));
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
      public ChangeUserSettingsResult changeUserEmail(ChangeUserEMailInput input) {
        ChangeUserSettingsResult result = new ChangeUserSettingsResult();

        if(changeUserEMailValidator.validate(input)) {
            // prepare the input
            String oldEmail = input.getOldEmail();
            String newEmail1 = input.getNewEmail1();
            
            // call the database
            DBUserQueries.changeEmail(oldEmail, newEmail1);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }        
        return result;
     }
        
      public ChangeUserSettingsResult changeUserName(ChangeUserNameInput input) {
        ChangeUserSettingsResult result = new ChangeUserSettingsResult();

        if(changeUserNameValidator.validate(input)) {
            // prepare the input
            String oldName = input.getOldName();
            String newName1 = input.getNewName1();
            
            // call the database
            DBUserQueries.changeName(oldName, newName1);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }        
        return result;
     } 
      
      public ChangeUserSettingsResult changeUserPassword(ChangeUserPasswordInput input) {
        ChangeUserSettingsResult result = new ChangeUserSettingsResult();

        if(changeUserPasswordValidator.validate(input)) {
            // prepare the input
            String newPassword1 = input.getNewPassword1();
            
            // call the database
            DBUserQueries.changePassword(input.getUsername(), newPassword1);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }        
        return result;
     } 
      
}

