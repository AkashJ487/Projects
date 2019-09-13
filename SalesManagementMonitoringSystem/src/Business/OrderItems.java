/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author JAGTAP
 */
public class OrderItems {
    
    private Order order;
    private int quantity;
    private double actualPrice;
    private double floorPrice;
    private double targetPrice;
    private double ceilingPrice;
    private Product product;
    private boolean status;
   // private Customer customer;
    //private SalesPerson salesPerson;

    public OrderItems()
    {
        status=true;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    public double getFloorPrice()
    {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /*public Customer getCustomer() {
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
    }*/
    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public double getTotalAuctualPrice() {
        return (this.actualPrice * this.quantity);
    }
    
    public double getTotalTargetPrice()
    {
        return (this.getTargetPrice()*this.quantity);
    }
    @Override
    public String toString()
    {
        return this.getProduct().getName();
    }
}
