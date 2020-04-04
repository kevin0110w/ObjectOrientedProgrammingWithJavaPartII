import java.util.List;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Flights {
   private List<Flight> flights;

    public Flights() {
        this.flights = new ArrayList<Flight>();
    }

    public void addFlight(Flight f){
        this.flights.add(f);
    }
    
    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        String flights = "";
        for (Flight f : this.flights) {
            flights += f.toString() + "\n";
        }
        return flights;
    }
}
