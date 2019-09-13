/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Employee.Person;
import Business.UserAccount.UserAccount;

/**
 *
 * @author JAGTAP 
 */
public class Doctor extends Person{
    
    private int id;
    private PatientDirectory docPatientDirectory;
    private static int count;
    //private UserAccount ua;
    
    public Doctor()
    {
        docPatientDirectory=new PatientDirectory();
        id=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientDirectory getDocPatientDirectory() {
        return docPatientDirectory;
    }

    public void setDocPatientDirectory(PatientDirectory docPatientDirectory) {
        this.docPatientDirectory = docPatientDirectory;
    }
    
}
