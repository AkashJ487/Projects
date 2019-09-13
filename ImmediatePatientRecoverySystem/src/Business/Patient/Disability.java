/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

/**
 *
 * @author JAGTAP
 */
public class Disability {
    
    private DisabilityType disabilityType;
    public enum DisabilityType {
        
        Autism("Autism"),ChronicIllness("Chronic Illness"),HearingLossAndDeafness("HearingLossDeafness"),
        IntellectualDisability("IntellectualDisability"),Dyslexia("Dyslexia"),Dyscalculia("Dyscalculia"),
        Epilepsy("Epilepsy"),SpinaBifida("SpinaBifida"),DownSyndrome("DownSyndrome"),CerebralPalsy("CerebralPalsy"),
        Depression("Depression");
        private String value;
        private DisabilityType(String value)
        {
            this.value=value;
        }

        public String getValue() {
            return value;
        }
        private String comment;
    }
    public Disability(DisabilityType d)
    {
        disabilityType = d;
    }

    public DisabilityType getDisabilityType() {
        return disabilityType;
    }

    public void setDisabilityType(DisabilityType disabilityType) {
        this.disabilityType = disabilityType;
    }
    
}
