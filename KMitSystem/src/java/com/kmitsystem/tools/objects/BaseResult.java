package com.kmitsystem.tools.objects;

import java.util.List;
import com.kmitsystem.tools.errorhandling.Error;
import java.util.ArrayList;


/**
 * @author Maik
 */
public class BaseResult {
    
    private List<Error> errorList = null;
    
    public void setErrorList(List<Error> errorList) {
        if(this.errorList == null)
            this.errorList = new ArrayList<Error>();
        
        for(int idx = 0; idx < errorList.size(); idx++) {
            System.out.println("[" + errorList.get(idx).getStatus() + "] " + errorList.get(idx).getTechnicalErrorMessage() + ": " + errorList.get(idx).getErrorMessage());
            this.errorList.add(errorList.get(idx));
        }
    }
    
    public List<Error> getErrorList() {
        if(errorList == null)
            return new ArrayList<Error>();
        else
            return errorList;
    }
    
}
