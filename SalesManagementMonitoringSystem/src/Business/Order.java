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
public class Order {
    
    private int id;
    private static int count;
    //private double floorPrice;
    //private double targetPrice;
    //private double ceilingPrice;
    private MarketOffer marketOffer;
    private Customer customer;
    private SalesPerson salesPerson;
   // private Product product;
    private ArrayList<OrderItems> listOfOrderItems;
    private char Status;

    public Order()
    {
        count+=1;
        id=count;
        Status='Y';
        listOfOrderItems=new ArrayList<OrderItems>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public double getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }*/

    public MarketOffer getMarketOffer() {
        return marketOffer;
    }

    public void setMarketOffer(MarketOffer marketOffer) {
        this.marketOffer = marketOffer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    /*public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }*/

    public ArrayList<OrderItems> getListOfOrderItems() {
        return listOfOrderItems;
    }

    public void setListOfOrderItems(ArrayList<OrderItems> listOfOrderItems) {
        this.listOfOrderItems = listOfOrderItems;
    }

    public char getStatus() {
        return Status;
    }

    public void setStatus(char Status) {
        this.Status = Status;
    }
   
    
    public OrderItems addOrderItems()
    {
        OrderItems oi=new OrderItems();
        listOfOrderItems.add(oi);
        return oi;
    }
    
    public double totalActualOrderPrice()
    {
        double sum=0;
        for(OrderItems oi : this.listOfOrderItems)
        {
            sum=sum+oi.getTotalAuctualPrice();
        }
        return sum;
    }
    public double totalTargetOrderPrice()
    {
        double sum=0;
        for(OrderItems oi : this.listOfOrderItems)
        {
            sum=sum+oi.getTotalTargetPrice();
        }
        return sum;
    }
}
