/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.DoctorRole;
import Business.Role.HospitalInventoryAdminRole;
import Business.Role.HospitalInventoryManagerRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class HospitalEnterprise extends Enterprise{

    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new HospitalInventoryManagerRole());
        roles.add(new DoctorRole());
        return roles;
    }
    
    @Override
    public String toString()
    {
        return EnterpriseType.Hospital.getValue();
    }
    
}
