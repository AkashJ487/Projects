/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BloodBank;

/**
 *
 * @author JAGTAP
 */
public class BloodGroup {
    private int quant;
    private int thresholdQuant;
    private int maxQuant;
    private boolean autoFlag;
    private String name;
    /*public enum BloodGroupType
    {
        A("A"),B("B"),AB("AB"),O("O");
        private String value;
        private BloodGroupType(String value)
        {
            this.value=value;
        }

        public String getValue() {
            return value;
        }
        
    }*/
    public BloodGroup()
    {
        thresholdQuant=5;
        maxQuant=10;
        autoFlag=true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getThresholdQuant() {
        return thresholdQuant;
    }

    public void setThresholdQuant(int thresholdQuant) {
        this.thresholdQuant = thresholdQuant;
    }

    public int getMaxQuant() {
        return maxQuant;
    }

    public void setMaxQuant(int maxQuant) {
        this.maxQuant = maxQuant;
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }

    public boolean isAutoFlag() {
        return autoFlag;
    }

    public void setAutoFlag(boolean autoFlag) {
        this.autoFlag = autoFlag;
    }
    
    

}
