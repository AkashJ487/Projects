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
public class SalesPersonsDirectory {
    
    private ArrayList<SalesPerson> listOfSalesPersons;
    
    public SalesPersonsDirectory()
    {
        listOfSalesPersons=new ArrayList<SalesPerson>();
    }

    public ArrayList<SalesPerson> getListOfSalesPersons() {
        return listOfSalesPersons;
    }
    
    public SalesPerson addSalesPerson()
    {
        SalesPerson sp=new SalesPerson();
        listOfSalesPersons.add(sp);
        return sp;
    }
    
    
}
