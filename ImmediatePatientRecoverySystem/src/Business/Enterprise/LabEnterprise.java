/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class LabEnterprise extends Enterprise{
    
    public LabEnterprise(String name)
    {
        super(name,EnterpriseType.Lab);
    }
    
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new LabAssistantRole());
        return roles;
    }
    
     @Override
    public String toString()
    {
        return EnterpriseType.Lab.getValue();
    }
    
}
