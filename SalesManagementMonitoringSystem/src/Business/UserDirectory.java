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
public class UserDirectory {
    
    private ArrayList<UserAccount> listOfUserAccounts;
    
    public UserDirectory()
    {
        listOfUserAccounts = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getListOfUserAccounts() {
        return listOfUserAccounts;
    }
    
    public UserAccount addUser()
    {
        UserAccount userAccount = new UserAccount();
        listOfUserAccounts.add(userAccount);
        return userAccount;
    }
    
    public UserAccount isValidUser(String userName, String pwd)
    {
        for(UserAccount ua : listOfUserAccounts)
        {
            if((userName.matches(ua.getUserName())) && (pwd.hashCode()==ua.getPassword()))
            {
                return ua;
            }
        }
        return null;
    }
    
}
