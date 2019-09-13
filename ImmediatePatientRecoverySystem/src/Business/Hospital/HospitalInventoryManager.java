/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.BloodBank.BloodGroup;
import Business.Employee.Person;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class HospitalInventoryManager extends Person{
    
    private ArrayList<BloodGroup> listOfBloodGroup;
    private String name;
    private WorkQueue workQueue;
    private int id;
    private static int count;
    
    
    public HospitalInventoryManager()
    {
        listOfBloodGroup=new ArrayList<>();
        workQueue = new WorkQueue();
        count++;
        id=count;
    }

    public ArrayList<BloodGroup> getListOfBloodGroup() {
        return listOfBloodGroup;
    }

    public void setListOfBloodGroup(ArrayList<BloodGroup> listOfBloodGroup) {
        this.listOfBloodGroup = listOfBloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
        
}
