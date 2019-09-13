/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Lab.LabAssistant;
import Business.Organization.LabAssistantOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Lab.LabAssistant.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author JAGTAP
 */
public class LabAssistantRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, (LabAssistantOrganization)organization, enterprise, business); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        return RoleType.LabAssistant.getValue();
    }
    
}
