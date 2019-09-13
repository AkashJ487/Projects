/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAGTAP
 */
public class PatientDisease {
    
    private String name;
    private String detectedDate;
    private ArrayList<Treatment> listOfTreatment;
    private boolean cured;
    private boolean death;
    private String shortDescription;
    
    public PatientDisease()
    {
        listOfTreatment=new ArrayList<>();
        cured=false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        try {
            detectedDate = String.valueOf(dateFormat.parse(dateFormat.format(new Date())));
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

    public String getDetectedDate() {
        return detectedDate;
    }

    public void setDetectedDate(String detectedDate) {
        this.detectedDate = detectedDate;
    }

    

    public ArrayList<Treatment> getListOfTreatment() {
        return listOfTreatment;
    }

    public void setListOfTreatment(ArrayList<Treatment> listOfTreatment) {
        this.listOfTreatment = listOfTreatment;
    }

    public boolean isCured() {
        return cured;
    }

    public void setCured(boolean cured) {
        this.cured = cured;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    
}
