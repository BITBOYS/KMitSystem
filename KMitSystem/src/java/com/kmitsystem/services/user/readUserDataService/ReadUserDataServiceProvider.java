/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.services.user.readUserDataService;

import com.kmitsystem.services.user.readUserDataService.input.ReadUserDataInput;
import com.kmitsystem.services.user.readUserDataService.validator.ReadUserValidator;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;

/**
 *
 * @author Malte
 */
public class ReadUserDataServiceProvider {
    
    ReadUserValidator readUserValidator = new ReadUserValidator();
    
    public BaseResult signInUser(ReadUserDataInput input) {
        BaseResult result = new BaseResult();

        if(readUserValidator.validate(input)) {
            // prepare the input
            User user = new User(input.getUser().getEmail(), input.getUser().getPassword());
            
            // call the database
            DBUserQueries.userPasswordOk(user);
        }
        
        // write the errors into the result object and empty the ErrorHandler
        if(ErrorHandler.getErrors().size() > 0) {
            result.setErrorList(ErrorHandler.getErrors());                        
            ErrorHandler.clear();
        }
        
        return result;
     }
}
