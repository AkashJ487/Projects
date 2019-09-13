/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.Supplier.Vaccine;
import Business.Supplier.VaccineDirectory;

/**
 *
 * @author JAGTAP
 */
public class Pharmacy {
    private VaccineDirectory vaccineList;
    private String pharmacyName;

    public Pharmacy(){
        vaccineList= new VaccineDirectory();
    }
    
    public VaccineDirectory getVaccine() {
        return vaccineList;
    }

    public void setVaccine(VaccineDirectory vaccine) {
        this.vaccineList = vaccine;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
    
    @Override
    public String toString(){
        return pharmacyName;
    }
    
}
