/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.OrganDonation.OrganDonationInventoryManager;
import Business.Role.OrganDonationInventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class OrganDonationInventoryManagerOrganization extends Organization {
    
    private ArrayList<OrganDonationInventoryManager> listOfOrganDonationInventoryManager;

    public OrganDonationInventoryManagerOrganization() {
        
        super(Type.OrganDonationInventoryManager.getValue());
        listOfOrganDonationInventoryManager=new ArrayList<>();
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new OrganDonationInventoryManagerRole());
        return roles;
    }

    public ArrayList<OrganDonationInventoryManager> getListOfOrganDonationInventoryManager() {
        return listOfOrganDonationInventoryManager;
    }

    public void setListOfOrganDonationInventoryManager(ArrayList<OrganDonationInventoryManager> listOfOrganDonationInventoryManager) {
        this.listOfOrganDonationInventoryManager = listOfOrganDonationInventoryManager;
    }
    
    @Override
    public String toString()
    {
        return super.getName();
    }
    
}
