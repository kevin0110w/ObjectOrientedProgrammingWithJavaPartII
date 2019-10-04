
public class Flight {

    private Airplane plane;
    private String departureAirportCode;
    private String destinationAirportCode;

    public Flight(Airplane id, String departureAirportCode, String destinationAirportCode) {
        this.plane = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    public String toString() {
        return this.plane + " (" + this.departureAirportCode + "-" + this.destinationAirportCode + ")";
    }
}
