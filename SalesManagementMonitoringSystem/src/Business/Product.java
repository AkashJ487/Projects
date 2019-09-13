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
public class Product {
    
    private ProductCatlog productCatlog;
    private double basePrice;
    private static int count;
    private int productId;
    private String name;
    /*private double floorPrice;
    private double targetPrice;
    private double ceilingPrice;*/
    private ArrayList<OrderItems> listOfOrderItems;
    
    public Product()
    {
        count+=1;
        listOfOrderItems=new ArrayList<OrderItems>();
        productId = count;
    }

    public ProductCatlog getProductCatlog() {
        return productCatlog;
    }

    public void setProductCatlog(ProductCatlog productCatlog) {
        this.productCatlog = productCatlog;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
    public ArrayList<OrderItems> getListOfOrderItems() {
        return listOfOrderItems;
    }

    public void setListOfOrderItems(ArrayList<OrderItems> listOfOrderItems) {
        this.listOfOrderItems = listOfOrderItems;
    }

    public int getProductId() {
        return productId;
    }
    
    public void addOrderItem(OrderItems oi)
    {
        listOfOrderItems.add(oi);
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
    public String toString()
    {
        return this.getName();
    }
    
    public double getRevenue()
    {
        double sum=0;
        for(OrderItems oi : listOfOrderItems)
        {
            sum+=oi.getTotalAuctualPrice();
        }
        return sum;
    }
    public double getTotRevenue()
    {
        double sum=0;
        for(OrderItems oi : listOfOrderItems)
        {
            sum+=oi.getTotalTargetPrice();
        }
        return sum;
    }
    public int getAboveTargetCount()
    {
        int sum=0;
        for(OrderItems oi : listOfOrderItems)
        {
            if(oi.getTotalAuctualPrice() > oi.getTotalTargetPrice())
                sum++;
        }
        return sum;
    }
}
