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
    
    public static final Error NAME_ALREADY_TAKEN_ERROR = new Error(1, "Der Name wird bereits verwendet");
    public static final Error DB_ERROR = new Error(2, "Auf der Datenbank ist ein Fehler aufgetreten");
    public static final Error TEAM_DOES_NOT_EXIST = new Error(3, "Das Team existiert nicht");
    public static final Error USER_DOES_NOT_EXIST = new Error(4, "Der Benutzer existiert nicht");
    public static final Error USER_ALREADY_IN_TEAM = new Error(5, "Der Benutzer ist bereit Mitglied des Teams"); 
    public static final Error EMAIL_ALREADY_TAKEN_ERROR = new Error(6, "Die E-Mail wird bereits verwendet");
    public static final Error UNKNOWN_EMAIL_ERROR = new Error(7, "Die E-Mail Adresse wurde nicht gefunden");
    public static final Error PASSWORDS_NOT_EQUAL = new Error(8, "Die beiden Passwörter stimmen nicht überein");
    public static final Error FALSE_LOGIN_INPUT = new Error(9, "Die E-Mail Adresse und das Passwort stimmen nicht überein");
    
}
