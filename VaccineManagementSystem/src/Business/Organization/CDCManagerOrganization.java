/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CDCAdminRole;
import Business.Role.CDCManagerRole;
import Business.Role.HospitalAdminRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class CDCManagerOrganization extends Organization{

    public CDCManagerOrganization() {
        super(Type.CDCManager.getValue());
    }
    
    @Override
    public HashSet<Role> getSupportedRole() {
        
        return null;
    }
    
    public String toString()
    {
        return Type.CDCManager.getValue();
    }

     
}
