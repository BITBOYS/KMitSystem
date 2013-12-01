
package com.kmitsystem.services.user.validator;

import com.kmitsystem.services.user.input.GetEverythingInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;

/**
 *
 * @author Smadback
 */
public class GetEverythingValidator {
    
    public boolean validate(GetEverythingInput input) {
        
        // checks if the team is existing
        if(!DBUserQueries.isUsernameExisting(input.getUsername())) {
            ErrorHandler.handle(Errors.USER_DOES_NOT_EXIST, GetEverythingValidator.class.getName() + ":isUsernameExisting");
            return false;
        }
        
        return true;
    }
}
