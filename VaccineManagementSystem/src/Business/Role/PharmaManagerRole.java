/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ClinicOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Hospital.Clinic.Pharmacy.PharmacyAdminWorkAreaJPanel;

/**
 *
 * @author JAGTAP
 */
public class PharmaManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      return new PharmacyAdminWorkAreaJPanel(userProcessContainer,  account, (ClinicOrganization) organization,  enterprise,  business);
    }
    @Override
    public String toString()
    {
        return RoleType.PharmaManager.getValue();
    }
}
