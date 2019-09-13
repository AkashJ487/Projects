/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.BloodBank.BloodBankInventoryManager;
import Business.Role.BloodBankInventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class BloodBankInventoryManagerOrganization extends Organization{
    
    private ArrayList<BloodBankInventoryManager> listOfBloodBankInventoryManager;
   
    public BloodBankInventoryManagerOrganization()
    {
        super(Type.BloodBankInventoryManager.getValue());
        listOfBloodBankInventoryManager=new ArrayList<>();
    }

    public ArrayList<BloodBankInventoryManager> getListOfBloodBankInventoryManager() {
        return listOfBloodBankInventoryManager;
    }

    public void setListOfBloodBankInventoryManager(ArrayList<BloodBankInventoryManager> listOfBloodBankInventoryManager) {
        this.listOfBloodBankInventoryManager = listOfBloodBankInventoryManager;
    }

    
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new BloodBankInventoryManagerRole());
        return roles;
    }
    
    @Override
    public String toString()
    {
        return super.getName();
    }
    
    
    
}
