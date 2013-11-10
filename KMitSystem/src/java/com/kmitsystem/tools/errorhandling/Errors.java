/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.tools.errorhandling;

/**
 * @author Maik
 */
public class Errors {
    
    public static final Error NAME_ALREADY_TAKEN_ERROR = new Error(00001, "Der Name wird bereits verwendet");
    public static final Error DB_CONNECTION_ERROR = new Error(00002, "Die Verbindung zur Datenbank ist fehlgeschlagen");
    
    
}
