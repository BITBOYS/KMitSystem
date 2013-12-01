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
    
    public static final Error NAME_ALREADY_TAKEN_ERROR = new Error(1, "Der Name wird bereits verwendet", Error.INFO);
    public static final Error DB_ERROR = new Error(2, "Es ist ein unbekannter Fehler aufgetreten", Error.ERROR);
    public static final Error TEAM_DOES_NOT_EXIST = new Error(3, "Das Team existiert nicht", Error.INFO);
    public static final Error USER_DOES_NOT_EXIST = new Error(4, "Der Benutzer existiert nicht", Error.ERROR);
    public static final Error USER_ALREADY_IN_TEAM = new Error(5, "Der Benutzer ist bereit Mitglied des Teams", Error.INFO); 
    public static final Error EMAIL_ALREADY_TAKEN_ERROR = new Error(6, "Die E-Mail wird bereits verwendet", Error.ERROR);
    public static final Error UNKNOWN_EMAIL_ERROR = new Error(7, "Die E-Mail Adresse wurde nicht gefunden", Error.ERROR);
    public static final Error PASSWORDS_NOT_EQUAL = new Error(8, "Die beiden Passwörter stimmen nicht &uuml;berein", Error.ERROR);
    public static final Error FALSE_LOGIN_INPUT = new Error(9, "Die E-Mail Adresse und das Passwort stimmen nicht &uuml;berein", Error.ERROR);
    public static final Error FORMATTING_DATA = new Error(10, "Beim Umwandeln des Datums ist ein Fehler aufgetreten", Error.ERROR);
    public static final Error EMAIL_REGISTER_INFO = new Error(11, "Eine E-Mail wurde zur Bestätigung an deine Mailadresse versendet", Error.INFO);
    public static final Error NO_ENTRYS_FOUND = new Error(12, "Es wurden keine Einträge gefunden", Error.INFO);
    public static final Error TOURNAMENT_DOES_NOT_EXIST = new Error(13, "Das Turnier existiert nicht", Error.ERROR);
    public static final Error TEAM_ALREADY_IN_TOURNAMENT = new Error(14, "Das Team ist bereits Mitglied des Turniers", Error.INFO);    
    public static final Error EMAILS_NOT_EQUAL = new Error(15, "Die beiden E-Mail Adressen stimmen nicht &uuml;berein", Error.ERROR);
    public static final Error NAMES_NOT_EQUAL = new Error(16, "Die beiden Namen stimmen nicht &uuml;berein", Error.ERROR);
    public static final Error SUCCESS_LOGGED_OUT = new Error(17, "Du hast dich erfolgreich ausgelogget", Error.SUCCESS);
    public static final Error SESSION_OUT = new Error(18, "Deine Session ist abgelaufen", Error.INFO);
    public static final Error EMAIL_CHANGE_OK = new Error(19, "Deine E-Mail wurde erfolgreich geändert", Error.INFO);
    public static final Error PASSWORD_CHANGE_REQUEST = new Error(20, "Ein neues Passwort wurde an deine Mailadresse versendet", Error.INFO); 
    public static final Error NAME_IS_FALSE = new Error(21, "Der eingegebene Name ist falsch", Error.ERROR); 
    public static final Error EDIT_SUCCESS = new Error(22, "Die Daten wurden erfolgreich ge&auml;ndert", Error.SUCCESS);
    public static final Error PASSWORD_FALSE = new Error(23, "Das eingegebene Passwort ist inkorrekt", Error.ERROR);
    public static final Error PASSWORD_NOT_VALID = new Error(24, "Das gew&auml;hlte Password entspricht nicht den Richtlinen", Error.ERROR);
    public static final Error EMAIL_IS_FALSE = new Error(24, "Die eingegebene E-Mail Adresse ist falsch", Error.ERROR);
    public static final Error LOGOUT_SUCCESSFUL = new Error(25, "Erfolgreich abgemeldet", Error.SUCCESS);
    public static final Error LOGOUT_FAILED = new Error(26, "Abmelden ist fehlgeschlagen", Error.ERROR);
    public static final Error LEAVE_TOURNAMENT_SUCCESSFUL = new Error(27, "Abmelden ist fehlgeschlagen", Error.SUCCESS);
    public static final Error USER_IS_TEAMLEADER = new Error(28, "Der Teamleiter kann nicht entfernt werden", Error.ERROR);
    public static final Error KICK_USER_SUCCESSFUL = new Error(29, "Spieler erfolgreich entfernt", Error.SUCCESS);
    
    
    
}
