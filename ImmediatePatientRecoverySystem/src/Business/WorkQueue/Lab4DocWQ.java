/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.MedicalTest;

/**
 *
 * @author JAGTAP
 */
public class Lab4DocWQ extends WorkRequest{
    
    private MedicalTest medicalTest;
    private String patientId;

    public MedicalTest getMedicalTest() {
        return medicalTest;
    }

    public void setMedicalTest(MedicalTest medicalTest) {
        this.medicalTest = medicalTest;
    }   

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    
}
