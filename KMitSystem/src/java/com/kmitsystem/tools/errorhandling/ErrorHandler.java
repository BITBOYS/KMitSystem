package com.kmitsystem.tools.errorhandling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maik
 */
public class ErrorHandler {
    
    private static List<Error> errors = new ArrayList<Error>();
    
    public static void handle(Error error) {
        errors.add(error);
    }
    
    public static void handle(Error error, String technicalErrorMessage) {
        error.setTechnicalErrorMessage(technicalErrorMessage);
        errors.add(error);
    }
    
    public static List<Error> getErrors() {
        return errors;
    }
    
    public static void clear() {
        errors.clear();
    }
    
}
