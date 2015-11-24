/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup.desk.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 13043328
 */
public final class ValidationUtils {
    
    private ValidationUtils(){}
    
    
    public static boolean validateField(String field){
        String fields = (String) field;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        if((fields.isEmpty()) || (fields.trim().equals("")))
            return false;
        try {
            sdf.parse(fields);
        } catch (ParseException ex) {
            return false;
        }
        return true;  
    }
}