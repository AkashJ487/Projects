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
public class OrdersDirectory {
    
    private ArrayList<Order> listOfOrders;
    
    public OrdersDirectory()
    {
        listOfOrders=new ArrayList<Order>();
    }

    public ArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }
    
    public Order addOrder()
    {
        Order o=new Order();
        listOfOrders.add(o);
        return o;
    }
    
}
