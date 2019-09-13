/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Clinic.Pharmacy;
import Business.Role.DoctorRole;
import Business.Role.PharmaManagerRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class ClinicOrganization extends Organization{
    Pharmacy p;
    public ClinicOrganization() {
       
        super(Organization.Type.Clinic.getValue());
         p = new Pharmacy();
    }

    public Pharmacy getP() {
        return p;
    }

    public void setP(Pharmacy p) {
        this.p = p;
    }
    
    @Override
    public HashSet<Role> getSupportedRole() {     
        roles.add(new DoctorRole() );
        roles.add(new PharmaManagerRole());
        return roles;
    }
    
    @Override
    public String toString()
    {
        return Type.Clinic.getValue();
    }
     
}