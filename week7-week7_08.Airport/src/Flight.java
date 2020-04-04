/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Flight {
    private Airplane airplane;
    private String departureAirportCode;
    private String destinationAirportCode;

    public Flight(Airplane airplane, String departureAirportCode, String destinationAirportCode) {
        this.airplane = airplane;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    public Airplane getAirplanes() {
        return this.airplane;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setAirplanes(Airplane airplane) {
        this.airplane = airplane;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    @Override
    public String toString() {
        return this.airplane + " (" + this.departureAirportCode + "-" + this.destinationAirportCode + ")";
    }
}
