/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAGTAP
 */
public class MedicalTest {
    
    private String name;
    private String result;
    private String date;
    
    public MedicalTest()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            date = String.valueOf(dateFormat.parse(dateFormat.format(new Date())));
        } 
        catch (ParseException ex) {
            Logger.getLogger(VitalSigns.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }   
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
