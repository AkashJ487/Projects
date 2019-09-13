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
public class FlightSchedule {
    
    //private String airline;
    private Airliners airliners;
    private ArrayList<Flight> listOfFlight;
    
    
    public FlightSchedule()
    {
        //airline="";
        listOfFlight=new ArrayList<Flight>();
        //airliners = new Airliners();
    }

    /*public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }*/

    public ArrayList<Flight> getListOfFlight() {
        return listOfFlight;
    }

    public void setListOfFlight(ArrayList<Flight> listOfFlight) {
        this.listOfFlight = listOfFlight;
    }

    public Airliners getAirliners() {
        return airliners;
    }

    public void setAirliners(Airliners airliners) {
        this.airliners = airliners;
    }
   
    public Flight addFlight()
    {
        Flight flight=new Flight();
        listOfFlight.add(flight);
        return flight;
    }
}
