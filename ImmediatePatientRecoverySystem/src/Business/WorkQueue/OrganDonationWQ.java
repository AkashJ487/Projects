/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.OrganDonation.Organ;

/**
 *
 * @author JAGTAP
 */
public class OrganDonationWQ extends WorkRequest{
    
    private Organ organ;
    //private String patientId;

    public Organ getOrgan() {
        return organ;
    }

    public void setOrgan(Organ organ) {
        this.organ = organ;
    }   

   /* public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }   */
    
}
