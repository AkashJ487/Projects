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
public class Fleet {
    //private String airline;
    private Airliners airliners;
    private ArrayList<Airplane> listOfAirplanes;
    
    public Fleet()
    {
        //airline="";
        listOfAirplanes = new ArrayList<Airplane>();
    }

    /*public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }*/

    public Airliners getAirliners() {
        return airliners;
    }

    public void setAirliners(Airliners airliners) {
        this.airliners = airliners;
    }
    
    public ArrayList<Airplane> getListOfAirplanes() {
        return listOfAirplanes;
    }

    public void setListOfAirplanes(ArrayList<Airplane> listOfAirplanes) {
        this.listOfAirplanes = listOfAirplanes;
    }
    
    public Airplane addAirplane()
    {
        Airplane airplane=new Airplane();
        listOfAirplanes.add(airplane);
        return airplane;
    }
    
    public void delAirplane(Airplane a)
    {
        this.listOfAirplanes.remove(a);
    }
    
}
