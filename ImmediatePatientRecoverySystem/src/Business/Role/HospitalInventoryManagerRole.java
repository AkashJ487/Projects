/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HospInventoryManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Hospital.Inventory.Manager.HospInventoryManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author JAGTAP
 */
public class HospitalInventoryManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HospInventoryManagerWorkAreaJPanel(userProcessContainer, account,(HospInventoryManagerOrganization) organization, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        return RoleType.HospitalInventoryManager.getValue();
    }
    
}
