/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Lab;

import Business.Employee.Person;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author JAGTAP
 */
public class LabAssistant extends Person{
    
    private WorkQueue workQueue;
    private int id;
    private static int count;
    private String name;
    
    public LabAssistant()
    {
        workQueue=new WorkQueue();
      //  count++;
        id=count;
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
        LabAssistant.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
}
