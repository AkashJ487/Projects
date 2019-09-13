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
public class ProductCatlog {
    
    private Supplier supplier;
    private ArrayList<Product> listOfProducts;
    
    public ProductCatlog()
    {
        listOfProducts=new ArrayList<Product>();
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ArrayList<Product> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }
    
    public Product addProduct()
    {
        Product p=new Product();
        listOfProducts.add(p);
        return p;
    }
}
