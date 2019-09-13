/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Employee.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class Patient extends Person{
    
    private String ID;
    private ArrayList<Person> poc;
    private MedicalData medicalData;
    private boolean death;
    private ArrayList<MedicalTest> listOfMedicalTests;
   // private UserAccount ua;
    
    public Patient()
    {
        poc = new ArrayList<>();
        medicalData=new MedicalData();
        listOfMedicalTests=new ArrayList<>();
        death=false;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Person> getPoc() {
        return poc;
    }

    public void setPoc(ArrayList<Person> poc) {
        this.poc = poc;
    }

    public MedicalData getMedicalHistory() {
        return medicalData;
    }

    public void setMedicalHistory(MedicalData medicalData) {
        this.medicalData = medicalData;
    }

    public MedicalData getMedicalData() {
        return medicalData;
    }

    public void setMedicalData(MedicalData medicalData) {
        this.medicalData = medicalData;
    }

    public boolean isDeath() {
        return death;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }
    
    

   /* public UserAccount getUa() {
        return ua;
    }

    public void setUa(UserAccount ua) {
        this.ua = ua;
    }*/

    public ArrayList<MedicalTest> getListOfMedicalTests() {
        return listOfMedicalTests;
    }

    public void setListOfMedicalTests(ArrayList<MedicalTest> listOfMedicalTests) {
        this.listOfMedicalTests = listOfMedicalTests;
    }
   
    public MedicalTest addMedicalTest()
    {
        MedicalTest mt=new MedicalTest();
        listOfMedicalTests.add(mt);
        return mt;
    }
}
