/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.OrganDonation;

import Business.Employee.Person;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class OrganDonationInventoryManager extends Person {
    
    private ArrayList<Organ> listOfOrgans;
    private WorkQueue workQueue;
    private int id;
    private static int count;
    private String name;
    
    public OrganDonationInventoryManager()
    {
        listOfOrgans=new ArrayList<>();
        workQueue = new WorkQueue();
        count++;
        id=count;
    }

    public ArrayList<Organ> getListOfOrgans() {
        return listOfOrgans;
    }

    public void setListOfOrgans(ArrayList<Organ> listOfOrgans) {
        this.listOfOrgans = listOfOrgans;
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

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        OrganDonationInventoryManager.count = count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString()
    {
        return name;
    }
}
