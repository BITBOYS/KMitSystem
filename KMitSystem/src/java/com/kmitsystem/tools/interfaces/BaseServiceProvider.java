package com.kmitsystem.tools.interfaces;

import com.kmitsystem.tools.errorhandling.ErrorHandler;

/**
 *
 * @author Maik
 */
public class BaseServiceProvider {
    
    private ErrorHandler errorHandler = null;
    
    public ErrorHandler getErrorHandler() {
        
        if(errorHandler == null)
            errorHandler = new ErrorHandler();
        
        return errorHandler;
    }
    
}
