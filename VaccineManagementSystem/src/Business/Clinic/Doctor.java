/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import Business.Organization.ClinicOrganization;

/**
 *
 * @author JAGTAP
 */
public class Doctor extends ClinicOrganization{
    private String docName;
    private String doctorId;
    private static int docCount;
    
    public Doctor(){
        doctorId= "DOC"+(++docCount);
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDoctorId() {
        return doctorId;
    } 
    
    @Override
    public String toString(){
        return docName;
    }
}
