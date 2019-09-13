/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author JAGTAP
 */
public class TravelAgency {
    
    private String agencyName;
    private Map<String,Airliners> listOfAirliner; 
    private MasterSchedule masterSchedule;
    private CustomerDirectory customerDirectory;
    
    public TravelAgency()
    {
        agencyName="FlyHigh";
        listOfAirliner=new HashMap<String,Airliners>();
        masterSchedule = new MasterSchedule();
        customerDirectory = new CustomerDirectory();
    }

    public Map<String, Airliners> getListOfAirliner() {
        return listOfAirliner;
    }

    public void setListOfAirliner(Map<String, Airliners> listOfAirliner) {
        this.listOfAirliner = listOfAirliner;
    }

    public MasterSchedule getMasterSchedule() {
        return masterSchedule;
    }

    public void setMasterSchedule(MasterSchedule masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    
    public Airliners addAirliners(String s)
    {
        Airliners airliners=new Airliners();
        airliners.setAirlines(s);
    //    airliners.setFlightSchedule(new FlightSchedule());
        listOfAirliner.put(airliners.getAirlines(),airliners);
        return airliners;
    }
    
}
