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
public class PriceComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight f1, Flight f2)
    {
        return (String.valueOf(f1.getPriceOfSeat()).compareTo(String.valueOf(f2.getPriceOfSeat())));
    }
    
}
