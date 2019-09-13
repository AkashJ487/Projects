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
public class Airplane {
    
    private int airplaneId;
    private String modelNumber;
    private String manufacturingCompany;
    private short manufacturingYear;
    private short totalSeats;
    private ArrayList<Flight> airplaneListOfFlight;
    private Fleet fleet;
    public Airplane()
    {
        airplaneId=0;
        modelNumber="";
        manufacturingCompany="";
        manufacturingYear=0;
        //totalSeats=150;
        airplaneListOfFlight= new ArrayList<Flight>();
    }
    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public short getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(short manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }


    public short getTotalSeats() {
        return totalSeats;
    }

    /*public short getTotalSeats() {
    return totalSeats;
    }
    public void setTotalSeats(short totalSeats) {
    this.totalSeats = totalSeats;
    }*/
    public void setTotalSeats(short totalSeats) {
        this.totalSeats = totalSeats;
    }

    public ArrayList<Flight> getAirplaneListOfFlight() {
        return airplaneListOfFlight;
    }

    public void setAirplaneListOfFlight(ArrayList<Flight> airplaneListOfFlight) {
        this.airplaneListOfFlight = airplaneListOfFlight;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(this.airplaneId);
    }
}
