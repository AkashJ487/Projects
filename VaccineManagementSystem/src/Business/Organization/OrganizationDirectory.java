/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.CDCEnterprise;
import Business.Organization.Organization.Type;
import Business.Supplier.Provider;
import Business.Supplier.Supplier;
import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Clinic.getValue())){
            organization = new ClinicOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Supplier.getValue())){
            organization = new SupplierOrganization();
            organizationList.add(organization);
        }
       
        else if (type.getValue().equals(Type.Provider.getValue())){
            organization = new ProviderOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CDCManager.getValue())){
            organization = new CDCManagerOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}