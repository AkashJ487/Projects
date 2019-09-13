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
public class MarketList {
    
    private ArrayList<Market> listOfMarkets;
    
    public MarketList()
    {
        listOfMarkets=new ArrayList<Market>();
    }

    public ArrayList<Market> getListOfMarkets() {
        return listOfMarkets;
    }
    
    public Market addMarket()
    {
        Market m = new Market();
        listOfMarkets.add(m);
        return m;
    }
    
}
