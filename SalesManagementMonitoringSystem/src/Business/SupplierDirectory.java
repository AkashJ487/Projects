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
public class SupplierDirectory {
    
    private ArrayList<Supplier> listOfSuppliers;
    
    public SupplierDirectory()
    {
        listOfSuppliers=new ArrayList<Supplier>();
    }

    public ArrayList<Supplier> getListOfSuppliers() {
        return listOfSuppliers;
    }
    
    public Supplier addSupplier()
    {
        Supplier s=new Supplier();
        listOfSuppliers.add(s);
        return s;
    }
    
}
