/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author JAGTAP
 */
public class Customer extends Person{
    
    private int Id;
    private Market market;
    private String Organization;
    private ArrayList<Order> listofOrders;
    
    public Customer()
    {
        listofOrders=new ArrayList<Order>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public ArrayList<Order> getListofOrders() {
        return listofOrders;
    }

    public void setListofOrders(ArrayList<Order> listofOrders) {
        this.listofOrders = listofOrders;
    }
    
    public void addOrders(Order o)
    {
        listofOrders.add(o);
    }
    
    public String toString()
    {
        return (this.getName()+"-"+this.getId());
    }
}
