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
public class MonitorSales {
    
    private int orderid;
    private String marketType;
    private String salesUserName;
    private String salesPersonsName;
    //private int customerId;
    private String organizationName;
    private double totalActualOrderPrice;
    private double totalTargetOrderPrice;
    private char orderDealFlag;
    private int productId;
    private String productName;
    private String supplierName;
    private double totOrderItemActualPrice;
    private double totOrderItemTargetPrice;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getSalesUserName() {
        return salesUserName;
    }

    public void setSalesUserName(String salesUserName) {
        this.salesUserName = salesUserName;
    }

    public String getSalesPersonsName() {
        return salesPersonsName;
    }

    public void setSalesPersonsName(String salesPersonsName) {
        this.salesPersonsName = salesPersonsName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public double getTotalActualOrderPrice() {
        return totalActualOrderPrice;
    }

    public void setTotalActualOrderPrice(double totalActualOrderPrice) {
        this.totalActualOrderPrice = totalActualOrderPrice;
    }

    public double getTotalTargetOrderPrice() {
        return totalTargetOrderPrice;
    }

    public void setTotalTargetOrderPrice(double totalTargetOrderPrice) {
        this.totalTargetOrderPrice = totalTargetOrderPrice;
    }

    public char getOrderDealFlag() {
        return orderDealFlag;
    }

    public void setOrderDealFlag(char orderDealFlag) {
        this.orderDealFlag = orderDealFlag;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getTotOrderItemActualPrice() {
        return totOrderItemActualPrice;
    }

    public void setTotOrderItemActualPrice(double totOrderItemActualPrice) {
        this.totOrderItemActualPrice = totOrderItemActualPrice;
    }

    public double getTotOrderItemTargetPrice() {
        return totOrderItemTargetPrice;
    }

    public void setTotOrderItemTargetPrice(double totOrderItemTargetPrice) {
        this.totOrderItemTargetPrice = totOrderItemTargetPrice;
    }
    
    
    
}
