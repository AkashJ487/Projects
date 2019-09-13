/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CDC;

/**
 *
 * @author JAGTAP
 */
public class Disease {
    private String diseaseName;
    private String diseaseId;
    private static int dCount;
    
    public Disease(){
        diseaseId= "Dis"+(++dCount);
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    @Override
    public String toString(){
    return diseaseName;
}
    
    
}
