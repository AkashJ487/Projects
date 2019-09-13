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
public class InsuranceEnterprise extends Enterprise{

    public InsuranceEnterprise(String name) {
        super(name, EnterpriseType.Insurance);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString()
    {
        return EnterpriseType.Insurance.getValue();
    }
    
}
