/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmitsystem.tools.errorhandling;

/**
 * @author Maik
 */
public class Error {
    
    public static final String INFO = "INFO";
    public static final String ERROR = "ERROR";
    public static final String SUCCESS = "SUCCESS";
    
    private int errorCode;
    private String errorMessage;
    private String technicalErrorMessage;
    private String status;

    public Error(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public Error(int errorCode, String errorMessage, String status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public Error(int errorCode, String errorMessage, String technicalErrorMessage, String status) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.technicalErrorMessage = technicalErrorMessage;
        this.status = status;
    }    

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTechnicalErrorMessage() {
        return technicalErrorMessage;
    }

    public void setTechnicalErrorMessage(String technicalErrorMessage) {
        this.technicalErrorMessage = technicalErrorMessage;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
