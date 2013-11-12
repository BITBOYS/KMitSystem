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
    public static final Error DB_CONNECTION_ERROR = new Error(00002, "Auf der Datenbank ist ein Fehler aufgetreten");
    public static final Error TEAM_DOES_NOT_EXIST = new Error(00003, "Das Team existiert nicht");
    public static final Error USER_DOES_NOT_EXIST = new Error(00004, "Der Benutzer existiert nicht");
    public static final Error USER_ALREADY_IN_TEAM = new Error(00005, "Der Benutzer ist bereit Mitglied des Teams"); 
    public static final Error EMAIL_ALREADY_TAKEN_ERROR = new Error(00006, "Die E-Mail wird bereits verwendet");
    public static final Error UNKNOWN_EMAIL_ERROR = new Error(00007, "Die E-Mail wurdenicht gefunden");
    
}
