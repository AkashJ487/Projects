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
    
    private int personId;
    private String name;
    private String emailId;
    private ArrayList<Seat> listOfSeats;
    
    public Person()
    {
        listOfSeats=new ArrayList<Seat>();
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public ArrayList<Seat> getSeat() {
        return listOfSeats;
    }

    public void setSeat(ArrayList<Seat> listOfSeats) {
        this.listOfSeats = listOfSeats;
    }
    
    @Override
    public String toString()
    {
        return (String.valueOf(this.personId));
    }
    
    public void addSeat(Seat s)
    {
        this.listOfSeats.add(s);
    }
}
