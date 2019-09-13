/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Lab.LabAssistant;
import Business.Role.BloodBankInventoryManagerRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class LabAssistantOrganization extends Organization{
    
    private ArrayList<LabAssistant> listOfLabAssistants;
    
    public LabAssistantOrganization()
    {
        super(Type.LabAssistant.getValue());
        listOfLabAssistants=new ArrayList<>();
    }

    public ArrayList<LabAssistant> getListOfLabAssistants() {
        return listOfLabAssistants;
    }

    public void setListOfLabAssistants(ArrayList<LabAssistant> listOfLabAssistants) {
        this.listOfLabAssistants = listOfLabAssistants;
    }
    
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new LabAssistantRole());
        return roles;
    }
    
    @Override
    public String toString()
    {
        return super.getName();
    }
    
}
