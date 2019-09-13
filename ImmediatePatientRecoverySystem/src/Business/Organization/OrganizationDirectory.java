/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

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
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.InsuranceManager.getValue())){
            organization = new InsuranceManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.HospInventoryManager.getValue())){
            organization = new HospInventoryManagerOrganization();
            organizationList.add(organization);
        }
       
        else if (type.getValue().equals(Organization.Type.BloodBankInventoryManager.getValue())){
            organization = new BloodBankInventoryManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.OrganDonationInventoryManager.getValue())){
            organization = new OrganDonationInventoryManagerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.LabAssistant.getValue())){
            organization = new LabAssistantOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
