/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class OrganDonationEnterprise extends Enterprise{

    public OrganDonationEnterprise(String name) {
        super(name, EnterpriseType.OrganDonation);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString()
    {
        return EnterpriseType.OrganDonation.getValue();
    }
    
}
