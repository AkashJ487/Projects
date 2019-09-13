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
public class Person {
    
    private String name;
    private String address;
    private String email;
    private ArrayList<UserAccount> listOfUserAccount;
    
    public Person()
    {
        listOfUserAccount=new ArrayList<UserAccount>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addUserAccount(UserAccount ua)
    {
        listOfUserAccount.add(ua);
    }
}
