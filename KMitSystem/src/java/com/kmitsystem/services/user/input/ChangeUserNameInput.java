/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmitsystem.services.user.input;

/**
 *
 * @author Oerlex
 */
public class ChangeUserNameInput {
    
    String oldName;
    String newName1;
    String newName2;

    public ChangeUserNameInput(String oldName, String newName1, String newName2) {
        this.oldName = oldName;
        this.newName1 = newName1;
        this.newName2 = newName2;
    }    
    
    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName1() {
        return newName1;
    }

    public void setNewName1(String newName1) {
        this.newName1 = newName1;
    }

    public String getNewName2() {
        return newName2;
    }

    public void setNewName2(String newName2) {
        this.newName2 = newName2;
    }    
}
