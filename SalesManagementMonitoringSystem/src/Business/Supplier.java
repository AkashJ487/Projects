/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author JAGTAP
 */
public class Supplier {
    
    private String name;
    private UserAccount userAccount;
    private ProductCatlog productCatlog;
    
    public Supplier()
    {
        productCatlog=new ProductCatlog();
        //userAccount=new UserAccount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public ProductCatlog getProductCatlog() {
        return productCatlog;
    }

    public void setProductCatlog(ProductCatlog productCatlog) {
        this.productCatlog = productCatlog;
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
}
