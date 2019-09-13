/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.CDC.Disease;

/**
 *
 * @author JAGTAP
 */
public class Vaccine {
    private String vaccineName;
    private String vaccineId;
    private static int vCount;
    private Disease disease;
    private int quantity;
    
    public Vaccine(){
        vaccineId= "VAC"+(++vCount);
        disease= new Disease();
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineId() {
        return vaccineId;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     @Override
    public String toString(){
    return vaccineName;
    }
}
