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
public class SalesPerson {
    
    //private Person person;
    private UserAccount userAccount;
    //private MasterProductCatlog masterProductCatlog;
    //private ArrayList<Customer> listOfCustomers;
    //private ArrayList<OrderItems> listOfOrderItems;
    private ArrayList<Order> listOfOrders;
    
    public SalesPerson()
    {
        //person=new Person();
        //listOfCustomers=new ArrayList<Customer>();
        //listOfOrderItems=new ArrayList<OrderItems>();
        listOfOrders= new ArrayList<Order>();
    }


    public UserAccount getUserAccount() {
        return userAccount;
    }

    /*public Person getPerson() {
    return person;
    }
    public void setPerson(Person person) {
    this.person = person;
    }
    public String getId() {
    return id;
    }
    public void setId(String id) {
    this.id = id;
    }*/
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
/*
    public MasterProductCatlog getMasterProductCatlog() {
        return masterProductCatlog;
    }

    public void setMasterProductCatlog(MasterProductCatlog masterProductCatlog) {
        this.masterProductCatlog = masterProductCatlog;
    }*/
/*
    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public void setListOfCustomers(ArrayList<Customer> listOfCustomers) {
        this.listOfCustomers = listOfCustomers;
    }

    public ArrayList<OrderItems> getListOfOrderItems() {
        return listOfOrderItems;
    }

    public void setListOfOrderItems(ArrayList<OrderItems> listOfOrderItems) {
        this.listOfOrderItems = listOfOrderItems;
    }
   
    public void addCustomer(Customer c)
    {
        listOfCustomers.add(c);
    }*/

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(ArrayList<Order> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }
    
    public void addOrder(Order order)
    {
        //OrderItems orderItems=new OrderItems();
        listOfOrders.add(order);
        //return orderItems;
    }
    
    @Override
    public String toString()
    {
        return this.getUserAccount().getUserName();
    }
    
    public double getTotalRevenue()
    {
        double sum=0;
        for(Order o: this.getListOfOrders())
        {
            sum+=o.totalActualOrderPrice();
        }
        return sum;
    }
    
    public double getTotalTargetRevenue()
    {
        double sum=0;
        for(Order o: this.getListOfOrders())
        {
            sum+=o.totalTargetOrderPrice();
        }
        return sum;
    }
    public double getTotalRevenueByMarket(String market)
    {
        double sum=0;
        for(Order o: this.getListOfOrders())
        {
            if(o.getMarketOffer().getMarket().getType().matches(market))
            {
                sum+=o.totalActualOrderPrice();
            }
        }
        return sum;
    }
    public double getTotalTagetRevenueByMarket(String market)
    {
        double sum=0;
        for(Order o: this.getListOfOrders())
        {
            if(o.getMarketOffer().getMarket().getType().matches(market))
            {
                sum+=o.totalTargetOrderPrice();
            }
        }
        return sum;
    }
}
