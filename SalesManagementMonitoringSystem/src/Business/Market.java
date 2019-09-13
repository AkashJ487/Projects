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
public class Market {
    
    private String type;
    private ArrayList<Customer> listOfCustomers;
    private MarketOffer marketOffer;
    
    public Market()
    {
        listOfCustomers=new ArrayList<Customer>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public MarketOffer getMarketOffer() {
        return marketOffer;
    }

    public void setMarketOffer(MarketOffer marketOffer) {
        this.marketOffer = marketOffer;
    }
    
    public Customer addCustomer()
    {
        Customer c=new Customer();
        listOfCustomers.add(c);
        return c;
    }
    
    public String toString()
    {
        return this.getType();
    }
}
