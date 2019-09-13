/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Hospital.Doctor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAGTAP
 */
public class VitalSigns {
    
    private String date;
    private float bp;
    private float temp;
    private float pluseRate;
    private float respirationRate;
    private Doctor d;
    
    public VitalSigns()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            date = String.valueOf(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException ex) {
            Logger.getLogger(VitalSigns.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getBp() {
        return bp;
    }

    public void setBp(float bp) {
        this.bp = bp;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPluseRate() {
        return pluseRate;
    }

    public void setPluseRate(float pluseRate) {
        this.pluseRate = pluseRate;
    }

    public float getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(float respirationRate) {
        this.respirationRate = respirationRate;
    }

    public Doctor getD() {
        return d;
    }

    public void setD(Doctor d) {
        this.d = d;
    }   
}
