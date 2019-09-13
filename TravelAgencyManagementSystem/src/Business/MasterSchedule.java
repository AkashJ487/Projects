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
public class MasterSchedule {
    
    private ArrayList<FlightSchedule> listOfFlightSchedules;
    
    public MasterSchedule()
    {
        listOfFlightSchedules = new ArrayList<FlightSchedule>();
    }

    public ArrayList<FlightSchedule> getListOfFlightSchedules() {
        return listOfFlightSchedules;
    }

    public void setListOfFlightSchedules(ArrayList<FlightSchedule> listOfFlightSchedules) {
        this.listOfFlightSchedules = listOfFlightSchedules;
    }
    
    public FlightSchedule addFlightSchedule(Airliners a)
    {
        FlightSchedule flightSchedule=new FlightSchedule();
        flightSchedule.setAirliners(a);
        listOfFlightSchedules.add(flightSchedule);
        return flightSchedule;
    }
}
