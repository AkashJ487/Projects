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
public class Airliners {
    
    private String airlines;
    private String iATA;
    private String iCAO;
    private String mainHub;
    private String country;
    private Fleet fleet;
    private FlightSchedule flightSchedule;

    public Airliners()
    {
        airlines="";
        fleet = new Fleet();
        flightSchedule = new FlightSchedule();
    }
    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public String getiATA() {
        return iATA;
    }

    public void setiATA(String iATA) {
        this.iATA = iATA;
    }

    public String getiCAO() {
        return iCAO;
    }

    public void setiCAO(String iCAO) {
        this.iCAO = iCAO;
    }

    public String getMainHub() {
        return mainHub;
    }

    public void setMainHub(String mainHub) {
        this.mainHub = mainHub;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return this.airlines;
    }
    
    
       
}
