/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.BloodBank.BloodGroup;

/**
 *
 * @author JAGTAP
 */
public class BloodBankWQ extends WorkRequest{
    
    private int quant;
    private BloodGroup bloodGroup;
    private boolean add;
    
    public BloodBankWQ()
    {
        add=false;
    }
    /*private enum BloodType
    {
        A("A"),B("B"),AB("B"),O("O");
        private String value;
        private BloodType(String value)
        {
            this.value=value;
        }

        public String getValue() {
            return value;
        }
        
    }*/

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    
}
