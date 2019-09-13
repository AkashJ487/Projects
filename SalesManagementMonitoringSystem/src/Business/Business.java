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
public class Business {
    
    private SalesPersonsDirectory salesPersonsDirectory;
    private SupplierDirectory supplierDirectory;
    private MasterProductCatlog masterProductCatlog;
    private MarketOfferCatlog marketOfferCatlog;
    private MarketList marketList;
    private OrdersDirectory ordersDirectory;
    private ArrayList<MonitorSales> listOfMonitorSales;
    private UserDirectory userDirectory;
    
    public Business()
    {
        salesPersonsDirectory=new SalesPersonsDirectory();
        supplierDirectory=new SupplierDirectory();
        masterProductCatlog=new MasterProductCatlog();
        marketList=new MarketList();
        marketOfferCatlog=new MarketOfferCatlog();
        ordersDirectory=new OrdersDirectory();
        listOfMonitorSales=new ArrayList<MonitorSales>();
        userDirectory=new UserDirectory();
    }

    public SalesPersonsDirectory getSalesPersonsDirectory() {
        return salesPersonsDirectory;
    }

    public void setSalesPersonsDirectory(SalesPersonsDirectory salesPersonsDirectory) {
        this.salesPersonsDirectory = salesPersonsDirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public MasterProductCatlog getMasterProductCatlog() {
        return masterProductCatlog;
    }

    public void setMasterProductCatlog(MasterProductCatlog masterProductCatlog) {
        this.masterProductCatlog = masterProductCatlog;
    }

    public MarketOfferCatlog getMarketOfferCatlog() {
        return marketOfferCatlog;
    }

    public void setMarketOfferCatlog(MarketOfferCatlog marketOfferCatlog) {
        this.marketOfferCatlog = marketOfferCatlog;
    }

    public MarketList getMarketList() {
        return marketList;
    }

    public void setMarketList(MarketList marketList) {
        this.marketList = marketList;
    }

    public OrdersDirectory getOrdersDirectory() {
        return ordersDirectory;
    }

    public void setOrdersDirectory(OrdersDirectory ordersDirectory) {
        this.ordersDirectory = ordersDirectory;
    }

    
    public ArrayList<MonitorSales> getListOfMonitorSales() {
        return listOfMonitorSales;
    }

    public UserDirectory getUserDirectory() {
        return userDirectory;
    }

    public void setUserDirectory(UserDirectory userDirectory) {
        this.userDirectory = userDirectory;
    }
    
    public MonitorSales addMonitorSales()
    {
        MonitorSales monitorSales=new MonitorSales();
        listOfMonitorSales.add(monitorSales);
        return monitorSales;
    }
}
