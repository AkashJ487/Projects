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
public class Treatment {
    
    private String date;
    private Doctor doctor;
    private String shortDescription;
    private String comments;
    
    public Treatment()
    {
        doctor=new Doctor();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
           // date = String.valueOf((Date)(dateFormat.parse(dateFormat.format(new Date()))));
           date = dateFormat.format(new Date());
        } 
        catch (Exception ex) {
            Logger.getLogger(VitalSigns.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    @Override
    public String toString()
    {
        return date;
    }
}
