package com.kmitsystem.tools;

import com.kmitsystem.services.team.validator.AddPlayerValidator;
import com.kmitsystem.tools.errorhandling.ErrorHandler;
import com.kmitsystem.tools.errorhandling.Errors;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Maik
 */
public class DateKonverter {
    
    public static String getWebDateString(Date date) {
            return new SimpleDateFormat("dd.MM.yyyy").format(date);
    }
    
    public static java.util.Date getSQLDate(String date) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        
        java.util.Date sqlDate = new java.util.Date();
        
        try {
            sqlDate = formatter.parse(date);
        } catch (ParseException ex) {
            ErrorHandler.handle(Errors.USER_ALREADY_IN_TEAM, AddPlayerValidator.class.getSimpleName());
        }
        
        return sqlDate;
    }
    
}
