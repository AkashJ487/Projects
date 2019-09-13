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
public class Seat {
    
    private String position;
    private boolean booked;
    //private double price;
    private Flight flight;
    private Person person;
    
    public Seat()
    {
        booked=false;
        position="";
        //price=0.0;
        //flight = new Flight();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /*public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }*/
    
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    @Override
    public String toString()
    {
        return this.position;
    }
}
