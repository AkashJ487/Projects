/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Organization.SupplierOrganization;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author JAGTAP
 */
public class Provider {
     private String providerName;
    private static int pCount;
    private String providerId;
    private VaccineDirectory vaccineList;
    private WorkQueue workQueue;
    
    public Provider(){
        providerId= "PID"+(++pCount);
        vaccineList= new VaccineDirectory();
        workQueue= new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public VaccineDirectory getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(VaccineDirectory vaccineList) {
        this.vaccineList = vaccineList;
    }
    
    @Override
    public String toString(){
        return providerName;
    }
}
