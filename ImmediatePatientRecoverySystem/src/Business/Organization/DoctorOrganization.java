/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Hospital.Doctor;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author JAGTAP
 */
public class DoctorOrganization extends Organization{

    private ArrayList<Doctor> listOfDoctor;
    public DoctorOrganization() {
        super(Type.Doctor.getValue());
        listOfDoctor=new ArrayList<>();
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new DoctorRole());
        return roles;
    }

    public ArrayList<Doctor> getListOfDoctor() {
        return listOfDoctor;
    }
    
    @Override
    public String toString()
    {
        return super.getName();
    }
    
}
