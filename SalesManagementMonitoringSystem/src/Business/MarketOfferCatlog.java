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
public class MarketOfferCatlog {
    
    private ArrayList<MarketOffer> listOfMarketOffer;
    
    public MarketOfferCatlog()
    {
        listOfMarketOffer=new ArrayList<MarketOffer>();
    }

    public ArrayList<MarketOffer> getListOfMarketOffer() {
        return listOfMarketOffer;
    }
    
    public MarketOffer addMarketOffer()
    {
        MarketOffer marketOffer=new MarketOffer();
        listOfMarketOffer.add(marketOffer);
        return marketOffer;
    }
}
