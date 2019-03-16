/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Freckles
 */
public class Flight {
    private Airplane plane;
    private String departureAirportCode;
    private String destinationAirportCode;
    
    public Flight(Airplane plane,String departureAirportCode,String destinationAirportCode) {
        this.plane = plane;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }
    
    
    public String toString() {
        return this.plane + " (" + this.departureAirportCode + "-" + this.destinationAirportCode + ")";
    }
    
}
