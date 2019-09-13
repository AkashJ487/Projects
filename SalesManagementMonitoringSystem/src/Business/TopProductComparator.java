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
public class TopProductComparator implements Comparator<TopProduct>{
    
    @Override
    public int compare(TopProduct t1, TopProduct t2)
    {
        if(t1.getCount() < t2.getCount())
            return 1;
        else if(t1.getCount() > t2.getCount())
            return -1;
        else
            return 0;
    }
    
}
