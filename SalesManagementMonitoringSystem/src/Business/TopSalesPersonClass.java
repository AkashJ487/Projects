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
public class TopSalesPersonClass {
    
    private String userid;
    private String name;
    private double totalRevenue;
    private double totalTargetRevenue;
    private String marketType;
    private double totalMarketRevenue;
    private double totalTargetMarketRevenue;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public double getTotalTargetRevenue() {
        return totalTargetRevenue;
    }

    public void setTotalTargetRevenue(double totalTargetRevenue) {
        this.totalTargetRevenue = totalTargetRevenue;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
    
    public double getTotalMarketRevenue() {
        return totalMarketRevenue;
    }

    public void setTotalMarketRevenue(double totalMarketRevenue) {
        this.totalMarketRevenue = totalMarketRevenue;
    }

    public double getTotalTargetMarketRevenue() {
        return totalTargetMarketRevenue;
    }

    public void setTotalTargetMarketRevenue(double totalTargetMarketRevenue) {
        this.totalTargetMarketRevenue = totalTargetMarketRevenue;
    }
    
    
    
}
