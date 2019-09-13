/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Comparator;

/**
 *
 * @author JAGTAP
 */
public class TopSalesPersonComparator implements Comparator<TopSalesPersonClass> {
    
    @Override
    public int compare(TopSalesPersonClass t1, TopSalesPersonClass t2)
    {
        if(t1.getTotalRevenue() < t2.getTotalRevenue())
            return 1;
        else if(t1.getTotalRevenue() > t2.getTotalRevenue())
            return -1;
        else
            return (t1.getUserid().compareTo(t2.getUserid()));
    }
}
