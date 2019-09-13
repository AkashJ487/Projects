/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.BloodBankInventoryAdminRole;
import Business.Role.BloodBankInventoryManagerRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class BloodBankEnterprise extends Enterprise{

    public BloodBankEnterprise(String name) {
        super(name, EnterpriseType.BloodBank);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new BloodBankInventoryManagerRole());
        return roles;
    }
    
    @Override
    public String toString()
    {
        return EnterpriseType.BloodBank.getValue();
    }
}
