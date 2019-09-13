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
public class MasterProductCatlog {
    
    private ArrayList<ProductCatlog> listOfProductCatlogs;
    
    public MasterProductCatlog()
    {
        listOfProductCatlogs=new ArrayList<ProductCatlog>();
    }

    public ArrayList<ProductCatlog> getListOfProductCatlogs() {
        return listOfProductCatlogs;
    }
    
    public void addProductCatlog(ProductCatlog pc)
    {
        listOfProductCatlogs.add(pc);
    }
}
