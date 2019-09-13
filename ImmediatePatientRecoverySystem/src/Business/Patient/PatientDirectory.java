/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class PatientDirectory {
    
    private ArrayList<Patient> listOfPatient;
    
    public PatientDirectory()
    {
        listOfPatient=new ArrayList<>();
    }
    
    public Patient addPatient()
    {
        Patient p = new Patient();
        listOfPatient.add(p);
        return p;
    }

    public ArrayList<Patient> getListOfPatient() {
        return listOfPatient;
    }

    public void setListOfPatient(ArrayList<Patient> listOfPatient) {
        this.listOfPatient = listOfPatient;
    }

    public boolean checkPatientId(String id)
    {
        for(Patient p:listOfPatient)
        {
            if(p.getID().equals(id))
            {
                return false;
            }
        }
        return true;
    }
}
