/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Hospital.HospitalInventoryManager;
import Business.Role.HospitalInventoryManagerRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class HospInventoryManagerOrganization extends Organization{
    
    private ArrayList<HospitalInventoryManager> listOfHospitalInventoryManager;

    public HospInventoryManagerOrganization()
    {
        super(Type.HospInventoryManager.getValue());
        listOfHospitalInventoryManager = new ArrayList<>();
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new HospitalInventoryManagerRole());
        return roles;
    }

    public ArrayList<HospitalInventoryManager> getListOfHospitalInventoryManager() {
        return listOfHospitalInventoryManager;
    }
    
   /* public HospitalInventoryManager addHospitalInventoryManager(){
        HospitalInventoryManager hospitalInventoryManager = new HospitalInventoryManager();
        listOfHospitalInventoryManager.add(hospitalInventoryManager);
        return hospitalInventoryManager;
    }*/
    
    @Override
    public String toString()
    {
        return super.getName();
    }
}
