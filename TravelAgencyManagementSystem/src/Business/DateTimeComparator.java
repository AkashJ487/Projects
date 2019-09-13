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
public class DateTimeComparator implements Comparator<Flight>{
    
    @Override
    public int compare(Flight f1, Flight f2)
    {
        int len1 = f1.getDepatureDate().length();
        int len2 = f2.getDepatureDate().length();
        int lim  = Math.min(len1, len2);
        char v1[] = f1.getDepatureDate().toCharArray();
        char v2[] = f2.getDepatureDate().toCharArray();
        int k = 0;
        while (k < lim)
        {
            char c1 = v1[k];
            char c2 = v2[k];
            if ( c1 != c2 )
            {
                return c1 - c2;
            }
            k++;
        }
        return (f1.getDepatureTime().compareTo(f2.getDepatureTime()));
    }
    
}
