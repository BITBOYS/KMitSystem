package com.kmitsystem.services.user.writeUserDataService;

import com.kmitsystem.services.user.writeUserDataService.input.CreateUserInput;
import com.kmitsystem.services.user.writeUserDataService.validator.CreateUserValidator;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 * @author Alex, Malte
 */
public class WriteUserDataServiceProvider {
    
    CreateUserValidator createUserValidator = new CreateUserValidator();
    
    public BaseResult createUser(CreateUserInput input) {
        BaseResult result = new BaseResult();

        if(createUserValidator.validate(input)) {
            // prepare the input
            User user = new User(input.getName(), input.getEmail(), input.getPassword());
            
            // call the database
            DBUserQueries.createUser(user);
            
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
    
    
        
}

