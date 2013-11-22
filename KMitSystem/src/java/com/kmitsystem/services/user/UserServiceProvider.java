package com.kmitsystem.services.user;

import com.kmitsystem.services.user.input.CreateUserInput;
import com.kmitsystem.services.user.input.SignInInput;
import com.kmitsystem.services.user.result.SignInResult;
import com.kmitsystem.services.user.validator.CreateUserValidator;
import com.kmitsystem.services.user.validator.SignInValidator;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 * @author Alex, Malte
 */
public class UserServiceProvider {
    
    CreateUserValidator createUserValidator = new CreateUserValidator();
    SignInValidator signInValidator = new SignInValidator();
    
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
    
    
        
}

