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
public class MarketOffer {
    
    private Market market;
    //private Order order;
    private double floorPercentage;
    private double targetPercentage;
    private double ceilingPercentage;

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/

    public double getFloorPercentage() {
        return floorPercentage;
    }

    public void setFloorPercentage(double floorPercentage) {
        this.floorPercentage = floorPercentage;
    }

    public double getTargetPercentage() {
        return targetPercentage;
    }

    public void setTargetPercentage(double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public double getCeilingPercentage() {
        return ceilingPercentage;
    }

    public void setCeilingPercentage(double ceilingPercentage) {
        this.ceilingPercentage = ceilingPercentage;
    }
    
    @Override
    public String toString()
    {
        return this.getMarket().getType();
    }
  
}
