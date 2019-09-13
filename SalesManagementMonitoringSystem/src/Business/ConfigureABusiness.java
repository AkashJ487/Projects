/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author JAGTAP
 */
public class ConfigureABusiness {
    
 public static Business Initialize(String s)
    {
        Business business = new Business();
        SalesPersonsDirectory spd = business.getSalesPersonsDirectory();
        MasterProductCatlog mpc = business.getMasterProductCatlog();
        SupplierDirectory sd = business.getSupplierDirectory();
        MarketOfferCatlog moc = business.getMarketOfferCatlog();
        MarketList ml = business.getMarketList();
        OrdersDirectory od = business.getOrdersDirectory();
        UserDirectory ud = business.getUserDirectory();
        BufferedReader bufferReader = null;
        String line = "";
        String separatedBy = ",";
        String tempMarket="";
        String tempSupplier="";
        Market market=null;
        Supplier supplier=null;
        try
        {
            bufferReader = new BufferedReader(new FileReader("src/CsvFile/CsvFileCustomer.txt"));
            while ((line = bufferReader.readLine())!=null)
            {
                String[] temp = line.split(separatedBy);
                if(!(temp[0].matches(tempMarket)))
                {
                       market = ml.addMarket();
                       MarketOffer marketOffer = moc.addMarketOffer();
                       market.setType(temp[0]);
                       marketOffer.setMarket(market);
                       market.setMarketOffer(marketOffer);
                       marketOffer.setFloorPercentage(Double.parseDouble(temp[1]));
                       marketOffer.setTargetPercentage(Double.parseDouble(temp[2]));
                       marketOffer.setCeilingPercentage(Double.parseDouble(temp[3]));
                       tempMarket=temp[0];
                       
                }
                Customer c=market.addCustomer();
                c.setOrganization(temp[4]);
                c.setId(Integer.parseInt(temp[5]));
                c.setName(temp[6]);
                c.setAddress(temp[7]);
                c.setEmail(temp[8]);
                c.setMarket(market);   
            }
            bufferReader = new BufferedReader(new FileReader("src/CsvFile/CsvFileSupplier.txt"));
            while ((line = bufferReader.readLine())!=null)
            {
                String[] temp = line.split(separatedBy);
                if(!(temp[0].matches(tempSupplier)))
                { 
                    supplier = sd.addSupplier();
                    supplier.setName(temp[0]);
                    supplier.getProductCatlog().setSupplier(supplier);
                    mpc.addProductCatlog(supplier.getProductCatlog());
                    UserAccount ua = ud.addUser();
                    supplier.setUserAccount(ua);
                    ua.setUserName(temp[1]);
                    ua.setPassword(temp[2].hashCode());
                    ua.setRole(temp[3]);
                    Person p = ua.getPerson();
                    p.setName(temp[4]);
                    p.setAddress(temp[5]);
                    p.setEmail(temp[6]);
                    p.addUserAccount(ua);
                    tempSupplier=supplier.getName();
                }
                Product p = supplier.getProductCatlog().addProduct();
                p.setProductCatlog(supplier.getProductCatlog());
                p.setName(temp[7]);
                p.setBasePrice(Double.parseDouble(temp[8]));
            }
            
            bufferReader = new BufferedReader(new FileReader("src/CsvFile/CsvFileSalePerson.txt"));
            while ((line = bufferReader.readLine())!=null)
            {
                String[] temp = line.split(separatedBy);
                SalesPerson sp=spd.addSalesPerson();
                UserAccount ua = ud.addUser();
                sp.setUserAccount(ua);
                ua.setUserName(temp[0]);
                ua.setPassword(temp[2].hashCode());
                ua.setRole(temp[1]);
                Person p = ua.getPerson();
                p.setName(temp[3]);
                p.setAddress(temp[4]);
                p.setEmail(temp[5]);
                p.addUserAccount(ua);
            }
            UserAccount uaAdmin = ud.addUser();
            uaAdmin.setUserName("aj.jain");
            uaAdmin.setPassword("aj@jain".hashCode());
            uaAdmin.setRole("Admin");
            Person pa = uaAdmin.getPerson();
            pa.setName("Ajay Jain");
            pa.setAddress("Huntington 234");
            pa.setEmail("aj@gmail.com");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Reading Csv file");
            e.printStackTrace();
        }   
        /*for(Supplier s1: business.getSupplierDirectory().getListOfSuppliers())
        {
            for (Product p1 : s1.getProductCatlog().getListOfProducts())
            {
                System.out.println(s1.getName()+" "+s1.getUserAccount().getUserName()+" "+p1.getName()+" "+
                        p1.getProductCatlog().getSupplier().getName());
            }
        }
        for(MarketOffer mo1:business.getMarketOfferCatlog().getListOfMarketOffer())
        {
            for(Customer c1 : mo1.getMarket().getListOfCustomers())
            {
                System.out.println(mo1.getCeilingPercentage()+" "+mo1.getTargetPercentage()+" "+mo1.getCeilingPercentage()+" "+
                    mo1.getMarket().getType()+" "+c1.getOrganization()+" "+c1.getName()+" "+c1.getId());
            }
        }
        for(SalesPerson sp1: business.getSalesPersonsDirectory().getListOfSalesPersons())
        {
            System.out.println(sp1.getUserAccount().getUserName()+" "+sp1.getUserAccount().getPerson().getName());
        }*/
        return business;
    }
 
    /*public static void main(String[] args) {
        
        Business business=Initialize("Xeroxs");
    }*/
    
}
