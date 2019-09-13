/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Hospital.Clinic.Pharmacy.DoctorJPanel;

/**
 *
 * @author JAGTAP
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DoctorJPanel(userProcessContainer);
    }
    
    @Override
    public String toString()
    {
        return RoleType.Doctor.getValue();
    }
    
}
